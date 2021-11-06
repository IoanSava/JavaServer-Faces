package ro.fii.javaserverfaces.beans;

import lombok.Getter;
import lombok.Setter;
import ro.fii.javaserverfaces.dao.WrittenTestDao;
import ro.fii.javaserverfaces.entities.WrittenTest;
import ro.fii.javaserverfaces.utils.DateUtils;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Getter
@Setter
@Named
@SessionScoped
public class CreateWrittenTestBean extends CreateExamBean {
    private String bibliography;

    @PostConstruct
    public void init() {
        examsDao = new WrittenTestDao();
    }

    @Override
    public void submit() {
        WrittenTest writtenTest = new WrittenTest(name, DateUtils.getTimestamp(startingTime), duration, bibliography);
        examsDao.create(writtenTest);
    }
}
