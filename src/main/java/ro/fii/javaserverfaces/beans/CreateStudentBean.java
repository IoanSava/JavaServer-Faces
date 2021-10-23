package ro.fii.javaserverfaces.beans;

import lombok.Getter;
import lombok.Setter;
import ro.fii.javaserverfaces.dao.StudentsDao;
import ro.fii.javaserverfaces.dtos.StudentDto;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.naming.NamingException;
import java.io.Serializable;
import java.sql.SQLException;

@Getter
@Setter
@Named
@SessionScoped
public class CreateStudentBean implements Serializable {
    private final StudentsDao studentsDao;
    private String name;
    private String assignedExams;

    public CreateStudentBean() throws NamingException {
        studentsDao = new StudentsDao();
    }

    public void submit() throws SQLException {
        StudentDto student = new StudentDto(name, assignedExams);
        studentsDao.create(student);
    }
}
