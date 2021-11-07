package ro.fii.javaserverfaces.beans;

import ro.fii.javaserverfaces.dao.WrittenTestDao;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class WrittenTestViewBean extends ExamViewBean {
    @EJB
    protected WrittenTestDao examsDao;

    @PostConstruct
    public void init() {
        entities = examsDao.getAll(examFilters);
    }

    public List getEntities() {
        entities = examsDao.getAll(examFilters);
        return entities;
    }
}
