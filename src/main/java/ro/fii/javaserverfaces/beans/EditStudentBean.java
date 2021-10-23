package ro.fii.javaserverfaces.beans;

import lombok.Getter;
import lombok.Setter;
import ro.fii.javaserverfaces.dao.StudentsDao;
import ro.fii.javaserverfaces.entities.Student;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.naming.NamingException;
import java.io.Serializable;
import java.sql.SQLException;

@Getter
@Setter
@Named
@ViewScoped
public class EditStudentBean implements Serializable {
    private final StudentsDao studentsDao;
    private Student student;

    public EditStudentBean() throws SQLException, NamingException {
        studentsDao = new StudentsDao();
        Integer id =
                Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("student_id"));
        student = studentsDao.getById(id);
    }

    public void submit() throws SQLException {
        studentsDao.update(student);
    }
}
