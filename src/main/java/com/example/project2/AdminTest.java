//package com.example.project2;
//
//import org.junit.Test;
//
//import java.sql.*;
//
//import static org.junit.Assert.*;
//
//public class AdminTest {
//    protected static Connection connection = Database.getConnection();
//
//
//    @Test
//    public void insertGebruiker() throws SQLException {
//        Client gebruiker = new Client(9389488, "test", "test", 0, 99, true);
//        gebruiker.insertGebruiker();
//        int id = gebruiker.getId();
//        int punten = gebruiker.getPunten();
//        int plaats = gebruiker.getPlaats();
//        assertEquals(9389488, id);
//        assertEquals("test", gebruiker.getNaam());
//        assertEquals("test", gebruiker.getWachtwoord());
//        assertEquals(0, punten);
//        assertEquals(99, plaats);
//    }
//
//    @Test
//    public void deleteGebruikerOnId() throws SQLException {
//        Client gebruiker = new Client(934, "testClient101", "test", 0, 99, true);
//        gebruiker.insertGebruiker();
//
//        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/betabit", "root", "");
//        Statement statement1 = connection.createStatement();
//        ResultSet result1 = statement1.executeQuery("SELECT * FROM `gebruiker` WHERE naam=\"testClient101\" ORDER BY `punten`");
//        result1.next();
//        Admin.refreshGebruikerslijst();
//        Integer id = result1.getInt("id");
//        Admin.deleteGebruikerOnId(id);
//        Admin.refreshGebruikerslijst();
//
//        Statement statement = connection.createStatement();
//        ResultSet result = statement.executeQuery("SELECT * FROM `gebruiker` WHERE naam=\"testClient101\" ORDER BY `punten`");
//        result.next();
//
//        assertEquals(false, result);
//    }
//
//    @Test
//    public void getTitel() {
//    }
//}