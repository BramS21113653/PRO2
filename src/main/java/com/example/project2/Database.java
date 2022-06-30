package com.example.project2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class    Database implements IDatabase {
    public static Connection makeConnection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/betabit", "root", "root");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Connection getConnection() {
        Connection connection = makeConnection();
        return connection;
    }
}
