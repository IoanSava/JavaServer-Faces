package ro.fii.javaserverfaces.dao;

import ro.fii.javaserverfaces.dtos.ExamDto;
import ro.fii.javaserverfaces.entities.Exam;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ExamsDao extends Dao {
    private static final String SELECT_ALL_EXAMS_QUERY = "SELECT id, name, starting_time, duration FROM exams;";
    private static final String SELECT_EXAM_ID_BY_STUDENT_ID = "SELECT exam_id FROM students_exams WHERE student_id = ?";
    private static final String CREATE_EXAM_COMMAND = "INSERT INTO exams(name, starting_time, duration) VALUES (?, ?, ?);";
    private static final String ASSIGN_EXAM_TO_STUDENT_COMMAND = "INSERT INTO students_exams(student_id, exam_id) VALUES(?, ?);";

    public ExamsDao() {
        try {
            connection = getConnection();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public List<Exam> getAll() throws SQLException {
        List<Exam> exams = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_EXAMS_QUERY);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Timestamp startingTime = resultSet.getTimestamp("starting_time");
                Float duration = resultSet.getFloat("duration");
                Exam exam = new Exam(id, name, startingTime, duration);
                exams.add(exam);
            }
        }

        return exams;
    }

    public String getExamIdsByStudentId(Integer studentId) throws SQLException {
        StringBuilder examIds = new StringBuilder();

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EXAM_ID_BY_STUDENT_ID)) {
            preparedStatement.setInt(1, studentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (examIds.length() != 0) {
                    examIds.append(',');
                }

                Integer id = resultSet.getInt("exam_id");
                examIds.append(id);
            }
        }

        return examIds.toString();
    }

    public void create(ExamDto exam) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_EXAM_COMMAND)) {
            preparedStatement.setString(1, exam.getName());
            preparedStatement.setTimestamp(2, exam.getStartingTime());
            preparedStatement.setFloat(3, exam.getDuration());
            preparedStatement.execute();
        }
    }

    public void assignExamToStudent(Integer examId, Integer studentId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ASSIGN_EXAM_TO_STUDENT_COMMAND)) {
            preparedStatement.setInt(1, studentId);
            preparedStatement.setInt(2, examId);
            preparedStatement.execute();
        }
    }
}
