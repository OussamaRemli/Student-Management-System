package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class config {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/ENSAO";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private Connection connection;

    public Connection connect() throws SQLException {
        connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        return connection;
    }

   
}


