package ro.fii.javaserverfaces.beans;

import lombok.Getter;
import lombok.Setter;
import ro.fii.javaserverfaces.dao.StudentsDao;
import ro.fii.javaserverfaces.dtos.StudentDto;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.inject.Named;
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

    public CreateStudentBean() {
        studentsDao = new StudentsDao();
    }

    public void submit() throws SQLException {
        StudentDto student = new StudentDto(name, assignedExams);
        studentsDao.create(student);
    }

    public void validateAssignedExams(FacesContext context, UIComponent component, Object value) {
        String assignedExams = (String) value;
        if (!assignedExams.matches("[0-9]+(,[0-9]+)*")) {
            ((UIInput) component).setValid(false);
            context.addMessage(component.getClientId(context), new FacesMessage("Bad format"));
        }
    }
}
