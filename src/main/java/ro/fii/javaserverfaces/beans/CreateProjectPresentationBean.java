package ro.fii.javaserverfaces.beans;

import lombok.Getter;
import lombok.Setter;
import ro.fii.javaserverfaces.dao.ProjectPresentationDao;
import ro.fii.javaserverfaces.entities.ProjectPresentation;
import ro.fii.javaserverfaces.utils.DateUtils;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Getter
@Setter
@Named
@SessionScoped
public class CreateProjectPresentationBean extends CreateExamBean {
    private boolean areTeamsAllowed;
    @EJB
    private ProjectPresentationDao examsDao;

    @Override
    public void submit() {
        ProjectPresentation projectPresentation = new ProjectPresentation(name, DateUtils.getTimestamp(startingTime), duration, areTeamsAllowed);
        examsDao.create(projectPresentation);
    }
}
