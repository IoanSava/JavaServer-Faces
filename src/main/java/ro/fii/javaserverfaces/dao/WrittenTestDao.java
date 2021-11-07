package ro.fii.javaserverfaces.dao;

import ro.fii.javaserverfaces.entities.WrittenTest;
import ro.fii.javaserverfaces.utils.ExamFilters;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class WrittenTestDao extends Dao<WrittenTest> {
    public List<WrittenTest> getAll(ExamFilters examFilters) {
        return entityManager.createNamedQuery("WrittenTest.getAll").getResultList();
    }
}
