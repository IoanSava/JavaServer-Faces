package ro.fii.javaserverfaces.dao;

import ro.fii.javaserverfaces.dtos.StudentDto;
import ro.fii.javaserverfaces.entities.Student;

import javax.naming.NamingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentsDao extends Dao {
    private static final String SELECT_ALL_STUDENTS_QUERY = "SELECT id, name FROM students;";
    private static final String SELECT_STUDENT_NAME_BY_ID = "SELECT name FROM students WHERE id = ?;";
    private static final String CREATE_STUDENT_COMMAND = "INSERT INTO students(name) VALUES (?);";
    private static final String UPDATE_STUDENT_NAME = "UPDATE students SET name = ? WHERE id = ?;";

    private final ExamsDao examsDao;

    public StudentsDao() throws NamingException {
        super();
        examsDao = new ExamsDao();
    }

    public List<Student> getAll() throws SQLException {
        List<Student> students = new ArrayList<>();

        try (Statement statement = getConnection().createStatement()) {
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

    public Student getById(Integer id) throws SQLException {
        Student student = null;
        try (PreparedStatement preparedStatement =
                     getConnection().prepareStatement(SELECT_STUDENT_NAME_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String assignedExams = examsDao.getExamIdsByStudentId(id);
                student = new Student(id, name, assignedExams);
            }
        }

        return student;
    }

    public void create(StudentDto student) throws SQLException {
        String[] generatedColumns = {"id"};

        try (PreparedStatement preparedStatement =
                     getConnection().prepareStatement(CREATE_STUDENT_COMMAND, generatedColumns)) {
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

    public void update(Student student) throws SQLException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(UPDATE_STUDENT_NAME)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getId());
            preparedStatement.execute();
        }

        examsDao.removeExamsForStudent(student.getId());

        String[] assignedExamIds = student.getAssignedExams().split(",");
        for (String examId : assignedExamIds) {
            examsDao.assignExamToStudent(Integer.parseInt(examId), student.getId());
        }
    }
}
