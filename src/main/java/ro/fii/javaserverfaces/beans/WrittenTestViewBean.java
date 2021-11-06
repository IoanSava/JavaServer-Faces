package ro.fii.javaserverfaces.beans;

import ro.fii.javaserverfaces.dao.WrittenTestDao;
import ro.fii.javaserverfaces.entities.WrittenTest;
import ro.fii.javaserverfaces.utils.ExamFilters;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class WrittenTestViewBean extends ExamViewBean<WrittenTest> {
    @PostConstruct
    public void init() {
        examsDao = new WrittenTestDao();
        entities = examsDao.getAll(examFilters);
    }
}
