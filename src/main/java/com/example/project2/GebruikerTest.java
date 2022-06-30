//package com.example.project2;
//
//import org.junit.Test;
//
//import java.sql.*;
//
//import static org.junit.Assert.*;
//
//public class GebruikerTest {
//
//    @Test
//    public void getGebruikerFromResult() throws SQLException {
//        Client gebruiker = new Client(934, "testClient101", "test", 0, 99, true);
//        gebruiker.insertGebruiker();
//
//        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/betabit", "root", "");
//        Statement statement = connection.createStatement();
//        ResultSet result = statement.executeQuery("SELECT * FROM `gebruiker` WHERE naam=\"testClient101\" ORDER BY `punten`");
//
//        result.next();
//        Gebruiker test = Gebruiker.getGebruikerFromResult(result, 93);
//
//        assertTrue(test instanceof Admin || test instanceof Client);
//    }
//}