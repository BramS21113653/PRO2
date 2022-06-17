package com.example.project2;

import java.util.*;
import java.sql.*;

public class Client extends Gebruiker {

    public Client(Integer id, String naam, String wachtwoord, Integer punten, Integer plaats, Boolean insert) throws SQLException {
        super(id, naam, wachtwoord, punten, plaats, insert);
        if (insert) {
            this.insertGebruiker();
        }
    }

    public void insertGebruiker() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/betabit", "root", "root");
        Statement stat = connection.createStatement();
        String query = " insert into gebruiker (id, naam, wachtwoord, isadmin, punten)"
                + " values (?, ?, ?, ?, ?)";
        Random rand = new Random();
        Integer int_random = rand.nextInt(99999999);
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setInt (1,int_random);
        preparedStmt.setString (2, this.naam);
        preparedStmt.setString   (3, this.wachtwoord);
        preparedStmt.setInt (4, 0);
        preparedStmt.setInt(5, this.punten);
        preparedStmt.execute();
        connection.close();
    }


    @Override
    public String getTitel() {
        return "Client " + naam;
    }
}
