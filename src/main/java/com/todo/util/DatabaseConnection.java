package com.todo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    // ✅ USE YOUR RAILWAY DB DETAILS HERE
    private static final String URL = "jdbc:mysql://trolley.proxy.rlwy.net:25517/railway?sslMode=REQUIRED";
    private static final String USERNAME = "root";  
    private static final String PASSWORD = "nplcJQmUcBCTeTKreoJruvOOAhoPaHQd"; 
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
            throw new SQLException("Database driver not found", e);
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
