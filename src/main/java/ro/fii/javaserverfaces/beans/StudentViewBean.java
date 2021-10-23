package ro.fii.javaserverfaces.beans;

import ro.fii.javaserverfaces.dao.StudentsDao;
import ro.fii.javaserverfaces.entities.Student;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

@Named
@ApplicationScoped
public class StudentViewBean extends DataViewBean<Student, Integer> {
    private final StudentsDao studentsDao;

    public StudentViewBean() throws SQLException, NamingException {
        studentsDao = new StudentsDao();
        entities = studentsDao.getAll();
    }

    public List<Student> getEntities() throws SQLException, NamingException {
        entities = studentsDao.getAll();
        return entities;
    }

    public String getEditStudentUrl(Integer id) {
        return String.format("/edit-students.xhtml?student_id=%s", id.toString());
    }
}
