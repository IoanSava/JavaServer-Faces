package ro.fii.javaserverfaces.dao;

import ro.fii.javaserverfaces.entities.Exam;
import ro.fii.javaserverfaces.utils.ExamFilters;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ExamsDao extends Dao<Exam> {
    public Exam getById(Integer id) {
        return entityManager.find(Exam.class, id);
    }

    public List<Exam> getAll(ExamFilters examFilters) {
        return entityManager.createNamedQuery("Exam.getAll").getResultList();
    }
}
