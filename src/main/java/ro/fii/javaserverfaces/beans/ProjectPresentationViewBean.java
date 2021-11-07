package ro.fii.javaserverfaces.beans;

import ro.fii.javaserverfaces.dao.ProjectPresentationDao;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class ProjectPresentationViewBean extends ExamViewBean {
    @EJB
    protected ProjectPresentationDao examsDao;

    @PostConstruct
    public void init() {
        entities = examsDao.getAll(examFilters);
    }

    public List getEntities() {
        entities = examsDao.getAll(examFilters);
        return entities;
    }
}
