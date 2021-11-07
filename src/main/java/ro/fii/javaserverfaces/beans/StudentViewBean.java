package ro.fii.javaserverfaces.beans;

import ro.fii.javaserverfaces.dao.StudentsDao;
import ro.fii.javaserverfaces.entities.Student;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class StudentViewBean extends DataViewBean<Student> {
    @EJB
    private StudentsDao studentsDao;

    @PostConstruct
    public void init() {
        entities = studentsDao.getAll();
    }

    public List<Student> getEntities() {
        entities = studentsDao.getAll();
        return entities;
    }

    public String getEditStudentUrl(Integer id) {
        return String.format("/edit-students.xhtml?student_id=%s", id.toString());
    }
}
