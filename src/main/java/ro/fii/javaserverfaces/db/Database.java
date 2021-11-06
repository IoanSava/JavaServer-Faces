package ro.fii.javaserverfaces.db;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Database {
    private final EntityManager entityManager;
    private static Database instance;

    private Database() {
        entityManager = Persistence.createEntityManagerFactory("ExamSchedulingPU").createEntityManager();
    }

    /**
     * Restricts the instantiation of Database class
     * to one "single" instance
     */
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }

        return instance;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
