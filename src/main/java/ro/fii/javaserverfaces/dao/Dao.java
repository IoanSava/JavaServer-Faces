package ro.fii.javaserverfaces.dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class Dao {
    private final DataSource examSchedulingDatabase;

    public Dao() throws NamingException {
        InitialContext initialContext = new InitialContext();
        this.examSchedulingDatabase = (DataSource) initialContext.lookup("java:/ExamScheduling");
    }

    protected Connection getConnection() throws SQLException {
        return examSchedulingDatabase.getConnection();
    }
}
