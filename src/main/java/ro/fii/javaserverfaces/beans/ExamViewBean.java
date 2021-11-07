package ro.fii.javaserverfaces.beans;

import lombok.Getter;
import lombok.Setter;
import ro.fii.javaserverfaces.entities.Exam;
import ro.fii.javaserverfaces.utils.ExamFilters;

@Getter
@Setter
public abstract class ExamViewBean extends DataViewBean<Exam> {
    protected ExamFilters examFilters = new ExamFilters();
}
