package ro.fii.javaserverfaces.dao;

import ro.fii.javaserverfaces.dtos.StudentDto;
import ro.fii.javaserverfaces.entities.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentsDao extends Dao {
    private static final String SELECT_ALL_STUDENTS_QUERY = "SELECT id, name FROM students;";
    private static final String CREATE_STUDENT_COMMAND = "INSERT INTO students(name) VALUES (?);";

    private final ExamsDao examsDao;

    public StudentsDao() {
        examsDao = new ExamsDao();
        try {
            connection = getConnection();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public List<Student> getAll() throws SQLException {
        List<Student> students = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_STUDENTS_QUERY);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String assignedExams = examsDao.getExamIdsByStudentId(id);
                Student student = new Student(id, name, assignedExams);
                students.add(student);
            }
        }

        return students;
    }

    public void create(StudentDto student) throws SQLException {
        String[] generatedColumns = {"id"};

        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(CREATE_STUDENT_COMMAND, generatedColumns)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.execute();


            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    Integer studentId = Math.toIntExact(generatedKeys.getLong(1));
                    String[] assignedExamIds = student.getAssignedExams().split(",");
                    for (String examId : assignedExamIds) {
                        examsDao.assignExamToStudent(Integer.parseInt(examId), studentId);
                    }
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        }
    }
}
