package ro.fii.javaserverfaces.beans;

import lombok.Getter;
import lombok.Setter;
import ro.fii.javaserverfaces.dao.StudentsDao;
import ro.fii.javaserverfaces.dtos.StudentDto;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Getter
@Setter
@Named
@SessionScoped
public class CreateStudentBean implements Serializable {
    private StudentsDao studentsDao;
    private String name;
    private String assignedExams;

    @PostConstruct
    public void init() {
        studentsDao = new StudentsDao();
    }

    public void submit() {
        StudentDto studentDto = new StudentDto(name, assignedExams);
        studentsDao.create(studentDto);
    }
}
