package ro.fii.javaserverfaces.beans;

import ro.fii.javaserverfaces.dao.ExamsDao;
import ro.fii.javaserverfaces.entities.Exam;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Named
@SessionScoped
public class GetExamsBean implements Serializable {
    private final ExamsDao examsDao;

    public GetExamsBean() {
        examsDao = new ExamsDao();
    }

    public List<Exam> getExams() throws SQLException {
        return examsDao.getAll();
    }
}
