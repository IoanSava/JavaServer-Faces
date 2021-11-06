package ro.fii.javaserverfaces.beans;

import lombok.Getter;
import lombok.Setter;
import ro.fii.javaserverfaces.dao.StudentsDao;
import ro.fii.javaserverfaces.dtos.StudentDto;
import ro.fii.javaserverfaces.entities.Student;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class EditStudentBean implements Serializable {
    private Integer id;
    @Getter
    @Setter
    private StudentDto studentDto;
    private StudentsDao studentsDao;

    @PostConstruct
    public void init() {
        studentsDao = new StudentsDao();
        id = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("student_id"));
        Student student = studentsDao.getById(id);
        studentDto = new StudentDto(student.getName(), student.getAssignedExamsAsIds());
    }

    public void submit() {
        studentsDao.update(id, studentDto);
    }
}
