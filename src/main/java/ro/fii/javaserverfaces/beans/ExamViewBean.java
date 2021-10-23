package ro.fii.javaserverfaces.beans;

import ro.fii.javaserverfaces.dao.ExamsDao;
import ro.fii.javaserverfaces.entities.Exam;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

@Named
@ApplicationScoped
public class ExamViewBean extends DataViewBean<Exam, Integer> {
    private final ExamsDao examsDao;

    public ExamViewBean() throws SQLException, NamingException {
        examsDao = new ExamsDao();
        entities = examsDao.getAll();
    }

    public List<Exam> getEntities() throws SQLException {
        entities = examsDao.getAll();
        return entities;
    }
}
