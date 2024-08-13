package com.vn.fpt.g1.shop.dbcontext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbContext implements AutoCloseable{
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=shoping-database;encrypt=false";
    private static final String USER = "sa";
    private static final String PASSWORD = "123";
    public static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Error: SQL Server JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error: Failed to connect to the database.");
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error: Failed to close the database connection.");
            e.printStackTrace();
        }
    }



}
