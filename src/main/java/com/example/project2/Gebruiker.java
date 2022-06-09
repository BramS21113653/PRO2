package com.example.project2;

import java.util.*;
import java.sql.*;

public class Gebruiker {
    private Integer id;
    private String naam;
    private String wachtwoord;
    private Integer isAdmin;
    private Integer punten;
    private ArrayList<Rit> ritten = new ArrayList<Rit>();
    public static ArrayList<Gebruiker> gebruikerslijst = new ArrayList<Gebruiker>();

    public Gebruiker(Integer id, String naam, String wachtwoord, Integer isAdmin, Integer punten, Boolean insert) throws SQLException {
        if (insert) {
            this.id = id;
            this.naam = naam;
            this.wachtwoord = wachtwoord;
            this.isAdmin = isAdmin;
            this.punten = punten;
            insertGebruiker();
            refreshGebruikerslijst();
        } else {
            gebruikerslijst.add(this);
        }
    }

    public void insertGebruiker() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/betabit", "root", "root");
        Statement stat = connection.createStatement();
        String query = " insert into gebruiker (id, naam, wachtwoord, isadmin)"
                + " values (?, ?, ?, ?)";
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setString (2, this.naam);
        preparedStmt.setString   (3, this.wachtwoord);
        preparedStmt.setInt(4, this.isAdmin);

        preparedStmt.execute();

        connection.close();
    }

    public void refreshGebruikerslijst() throws SQLException {
        gebruikerslijst.clear();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/betabit", "root", "root");
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM `gebruiker`");

        try {
            while (result.next()) {
                //gebruikers maken van database gegevens
                Gebruiker gebruiker = getGebruikerFromResult(result);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public static Gebruiker getGebruikerFromResult(ResultSet result){
        try {
            Integer id = result.getInt("id");
            String naam = result.getString("naam");
            String wachtwoord = result.getString("wachtwoord");
            Integer isAdmin = result.getInt("isadmin");
            Integer punten = result.getInt("punten");
            return new Gebruiker(id, naam, wachtwoord, isAdmin, punten, false);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    public static ArrayList<Gebruiker> getGebruikersLijst() {
        return gebruikerslijst;
    }

    public String getNaam() {
        return naam;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIsAdmin() {return isAdmin;}

    public Integer getPunten() {return punten;}

    public void addRit(Rit rit) {
        this.ritten.add(rit);
    }

public Gebruiker getGebruikerOnName(Integer id) {
    Gebruiker match = null;
    for (Gebruiker gebruiker : gebruikerslijst){
        if (gebruiker.getId().equals(id)) {
            match = gebruiker;
        }
    }
    return match;
}

    @Override
    public String toString() {
        return  "Naam = " + naam + "\n" +
                "Ritten = " + ritten + "\n" +
                "IsAdmin = " + isAdmin + "\n";
    }
}