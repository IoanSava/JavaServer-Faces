package ro.fii.javaserverfaces.dao;

import ro.fii.javaserverfaces.entities.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class Dao<T extends AbstractEntity> {
    @PersistenceContext
    protected EntityManager entityManager;

    public void create(T entity) {
        entityManager.persist(entity);
        entityManager.flush();
    }
}
