package ro.fii.javaserverfaces.dao;

import ro.fii.javaserverfaces.db.Database;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class Dao {
    protected Connection connection = null;

    protected Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = Database.getInstance().getConnection();
        }
        return connection;
    }
}
