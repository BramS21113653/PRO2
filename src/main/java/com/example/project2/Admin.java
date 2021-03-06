package com.example.project2;

import java.util.*;
import java.sql.*;

public class Admin extends Gebruiker implements IWijzigen {

    public Admin(Integer id, String naam, String wachtwoord, Integer punten, Integer plaats, Boolean insert) throws SQLException {
        super(id, naam, wachtwoord, punten, plaats, insert);
    }

    public void insertGebruiker() throws SQLException {
        Connection connection = Database.getConnection();

        Statement stat = connection.createStatement();
        String query = " insert into gebruiker (id, naam, wachtwoord, isadmin, punten)"
                + " values (?, ?, ?, ?, ?)";
        Random rand = new Random();
        Integer int_random = rand.nextInt(99999999);
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setInt (1,int_random);
        preparedStmt.setString (2, this.naam);
        preparedStmt.setString   (3, this.wachtwoord);
        preparedStmt.setInt (4, 1);
        preparedStmt.setInt(5, this.punten);
        preparedStmt.execute();
        connection.close();
    }
    public static void deleteGebruikerOnId(Integer id) throws SQLException {
        if (id != null) {
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement(" DELETE FROM gebruiker WHERE id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Gebruiker:" + Gebruiker.getGebruikerOnId(id).toString() + "is verwijderd uit het systeem.");
        }
    }
    @Override
    public String getTitel() {
        return "Admin " + naam;
    }
}