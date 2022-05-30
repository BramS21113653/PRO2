package com.example.project2;

import java.util.*;
import java.sql.*;

public class Gebruiker {
    private Integer id;
    private String naam;
    private String wachtwoord;
    private Integer isAdmin;
    private ArrayList<Rit> ritten = new ArrayList<Rit>();
    public static ArrayList<Gebruiker> gebruikerslijst = new ArrayList<Gebruiker>();
    //db
    private static String dbUrl = "jdbc:mysql://localhost:3306/database";
    private static String dbUsername = "root";
    private static String dbPassword = "mysql";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load JDBC driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Could not connect to DB: " + e.getMessage());
        }
        return connection;
    }
    //db

    public Gebruiker(Integer id, String naam, String wachtwoord, Integer isAdmin) throws SQLException {
        this.id = id;
        this.naam = naam;
        this.wachtwoord = wachtwoord;
        this.isAdmin = isAdmin;
        insertGebruiker();
        refreshGebruikerslijst();
    }

    public void insertGebruiker() throws SQLException {
        String query = " insert into gebruiker (id, naam, wachtwoord, isadmin)"
                + " values (?, ?, ?, ?)";
        PreparedStatement preparedStmt = getConnection().prepareStatement(query);
        preparedStmt.setString (2, this.naam);
        preparedStmt.setString   (3, this.wachtwoord);
        preparedStmt.setInt(4, this.isAdmin);

        preparedStmt.execute();

        getConnection().close();
    }

    public void refreshGebruikerslijst(){
        //gebruikerslijst legen
        //database tabellen inlezen
        //gebruikers maken van database gegevens
        //gebruikerslijst invullen
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