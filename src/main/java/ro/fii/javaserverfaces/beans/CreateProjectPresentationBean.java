package ro.fii.javaserverfaces.beans;

import lombok.Getter;
import lombok.Setter;
import ro.fii.javaserverfaces.dao.ProjectPresentationDao;
import ro.fii.javaserverfaces.entities.ProjectPresentation;
import ro.fii.javaserverfaces.utils.DateUtils;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Getter
@Setter
@Named
@SessionScoped
public class CreateProjectPresentationBean extends CreateExamBean {
    private boolean areTeamsAllowed;

    @PostConstruct
    public void init() {
        examsDao = new ProjectPresentationDao();
    }

    @Override
    public void submit() {
        ProjectPresentation projectPresentation = new ProjectPresentation(name, DateUtils.getTimestamp(startingTime), duration, areTeamsAllowed);
        examsDao.create(projectPresentation);
    }
}
