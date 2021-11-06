package ro.fii.javaserverfaces.beans;

import lombok.Getter;
import lombok.Setter;
import ro.fii.javaserverfaces.dao.ExamsDao;
import ro.fii.javaserverfaces.entities.Exam;
import ro.fii.javaserverfaces.utils.ExamFilters;

import java.util.List;

@Getter
@Setter
public class ExamViewBean<T extends Exam> extends DataViewBean<Exam> {
    protected ExamFilters examFilters = new ExamFilters();
    protected ExamsDao<T> examsDao;

    public List getEntities() {
        entities = examsDao.getAll(examFilters);
        return entities;
    }
}
