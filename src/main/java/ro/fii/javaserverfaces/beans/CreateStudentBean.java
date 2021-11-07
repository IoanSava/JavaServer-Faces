package ro.fii.javaserverfaces.beans;

import lombok.Getter;
import lombok.Setter;
import ro.fii.javaserverfaces.dao.StudentsDao;
import ro.fii.javaserverfaces.dtos.StudentDto;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Getter
@Setter
@Named
@SessionScoped
public class CreateStudentBean implements Serializable {
    @EJB
    private StudentsDao studentsDao;
    private String name;
    private String assignedExams;

    public void submit() {
        StudentDto studentDto = new StudentDto(name, assignedExams);
        studentsDao.create(studentDto);
    }
}
