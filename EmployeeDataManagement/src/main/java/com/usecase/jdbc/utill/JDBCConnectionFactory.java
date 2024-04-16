package com.usecase.jdbc.utill;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionFactory {
    // JDBC connection URL
    private static final String URL = "jdbc:mysql://localhost:3306/Employee";
    private static final String USER = "root";
    private static final String PASSWORD = "udaya";

    private static Connection connection;


    private JDBCConnectionFactory() {
    }

    // Method to get the connection instance
    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Load the MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Create the connection
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace(); // Handle any errors
            }
        }
        return connection;
    }

    // Method to close the connection
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Handle any errors
            }
        }
    }
}

