package ro.fii.javaserverfaces.beans;

import ro.fii.javaserverfaces.dao.StudentsDao;
import ro.fii.javaserverfaces.entities.Student;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Named
@SessionScoped
public class GetStudentsBean implements Serializable {
    private final StudentsDao studentsDao;

    public GetStudentsBean() {
        studentsDao = new StudentsDao();
    }

    public List<Student> getStudents() throws SQLException {
        return studentsDao.getAll();
    }
}
