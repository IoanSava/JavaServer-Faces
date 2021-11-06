package ro.fii.javaserverfaces.dao;

import ro.fii.javaserverfaces.entities.Exam;
import ro.fii.javaserverfaces.utils.ExamFilters;

import java.util.List;

public abstract class ExamsDao<T extends Exam> extends Dao<Exam> {
    public abstract List<T> getAll(ExamFilters examFilters);
}
