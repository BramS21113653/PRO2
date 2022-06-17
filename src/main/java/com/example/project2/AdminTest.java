package com.example.project2;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

public class AdminTest {
    protected static Connection connection = Database.getConnection();


    @Test
    public void insertGebruiker() throws SQLException {
    Client gebruiker = new Client(9389488, "test", "test", 0, 99, true);
    gebruiker.insertGebruiker();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `gebruiker` ORDER BY `punten`");
            System.out.println(result);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (connection != null) {
            }
        }


    }

    @Test
    public void deleteGebruikerOnId() {
    }

    @Test
    public void getTitel() {
    }
}