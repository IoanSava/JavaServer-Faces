package ro.fii.javaserverfaces.beans;

import lombok.Getter;
import lombok.Setter;
import ro.fii.javaserverfaces.dao.ExamsDao;
import ro.fii.javaserverfaces.dtos.ExamDto;
import ro.fii.javaserverfaces.utils.DateUtils;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.naming.NamingException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;

@Getter
@Setter
@Named
@SessionScoped
public class CreateExamBean implements Serializable {
    private final ExamsDao examsDao;
    private String name;
    private Date startingTime;
    private Float duration;

    public CreateExamBean() throws NamingException {
        examsDao = new ExamsDao();
    }

    public void submit() throws SQLException {
        ExamDto exam = new ExamDto(name, DateUtils.getTimestamp(startingTime), duration);
        examsDao.create(exam);
    }
}
