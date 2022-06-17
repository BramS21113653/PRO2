package com.example.project2;

import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.*;

public class GebruikerTest {

    @Test
    public void resetPunten() {
    }

    @Test
    public void refreshGebruikerslijst() {
    }

    @Test
    public void getGebruikerFromResult() throws SQLException {
        Client gebruiker = new Client(934, "testClient101", "test", 0, 99, true);
        gebruiker.insertGebruiker();

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/betabit", "root", "");
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM `gebruiker` WHERE naam=\"testClient101\" ORDER BY `punten`");

        result.next();
        Gebruiker test = Gebruiker.getGebruikerFromResult(result, 93);

        assertTrue(test instanceof Admin || test instanceof Client);
    }

    @Test
    public void getGebruikersLijst() {
    }

    @Test
    public void getNaam() {
    }

    @Test
    public void getId() {
    }

    @Test
    public void getPunten() {
    }

    @Test
    public void setPunten() {
    }

    @Test
    public void addPunten() {
    }

    @Test
    public void getPlaats() {
    }

    @Test
    public void setPlaats() {
    }

    @Test
    public void getIngelogdId() {
    }

    @Test
    public void setIngelogdId() {
    }

    @Test
    public void getWachtwoord() {
    }

    @Test
    public void getGebruikerOnId() {
    }

    @Test
    public void getTitel() {
    }
}