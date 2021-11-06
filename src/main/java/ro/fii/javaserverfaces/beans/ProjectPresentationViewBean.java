package ro.fii.javaserverfaces.beans;

import ro.fii.javaserverfaces.dao.ProjectPresentationDao;
import ro.fii.javaserverfaces.entities.ProjectPresentation;
import ro.fii.javaserverfaces.utils.ExamFilters;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class ProjectPresentationViewBean extends ExamViewBean<ProjectPresentation> {
    @PostConstruct
    public void init() {
        examsDao = new ProjectPresentationDao();
        entities = examsDao.getAll(examFilters);
    }
}
