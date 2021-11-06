package ro.fii.javaserverfaces.dao;

import ro.fii.javaserverfaces.entities.WrittenTest;
import ro.fii.javaserverfaces.utils.ExamFilters;

import java.util.List;

public class WrittenTestDao extends ExamsDao<WrittenTest> {
    @Override
    public List<WrittenTest> getAll(ExamFilters examFilters) {
        return entityManager.createNamedQuery("WrittenTest.getAll").getResultList();
    }
}
