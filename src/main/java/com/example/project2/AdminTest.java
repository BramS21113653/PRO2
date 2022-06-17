package com.example.project2;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class AdminTest {
    protected static Connection connection = .get;


    @Test
    public void insertGebruiker() throws SQLException {
    Client gebruiker = new Client(9389488, "test", "test", 0, 99, true);
    gebruiker.insertGebruiker();



    }

    @Test
    public void deleteGebruikerOnId() {
    }

    @Test
    public void getTitel() {
    }
}