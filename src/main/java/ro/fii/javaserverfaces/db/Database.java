package ro.fii.javaserverfaces.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    /**
     * jdbc:sub-protocol:identifier
     */
    private static final String URL = "jdbc:postgresql://localhost:5432/ExamScheduling";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "password";
    private static final String POSTGRESQL_DRIVER = "org.postgresql.Driver";
    private static Database instance;
    private Connection connection;

    private Database() {
        try {
            Class.forName(POSTGRESQL_DRIVER);
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println("Database Connection Creation Failed: " + exception.getMessage());
        }
    }

    /**
     * Restricts the instantiation of Database class
     * to one "single" instance
     */
    public static Database getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new Database();
        }

        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
