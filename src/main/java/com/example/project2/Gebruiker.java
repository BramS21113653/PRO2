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
        private static String dbUrl = "jdbc:mysql://localhost:3306/betabit";
        private static String dbUsername = "root";
        private static String dbPassword = "root";

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

    public Gebruiker(Integer id, String naam, String wachtwoord, Integer isAdmin, Boolean insert) throws SQLException {
        this.id = id;
        this.naam = naam;
        this.wachtwoord = wachtwoord;
        this.isAdmin = isAdmin;
        insertGebruiker();
        refreshGebruikerslijst();
    }
    public Gebruiker(Integer id, String naam, String wachtwoord, Integer isAdmin) throws SQLException {
        this.id = id;
        this.naam = naam;
        this.wachtwoord = wachtwoord;
        this.isAdmin = isAdmin;
        //gebruikerslijst invullen
        gebruikerslijst.add(this);
    }

    public void insertGebruiker() throws SQLException {
        Connection connecton = getConnection();
        String query = " insert into gebruiker (id, naam, wachtwoord, isadmin)"
                + " values (?, ?, ?, ?)";
        PreparedStatement preparedStmt = connecton.prepareStatement(query);
        preparedStmt.setString (2, this.naam);
        preparedStmt.setString   (3, this.wachtwoord);
        preparedStmt.setInt(4, this.isAdmin);

        preparedStmt.execute();

        connecton.close();
    }

    public void refreshGebruikerslijst() throws SQLException {
        //gebruikerslijst legen
        gebruikerslijst.clear();
        Statement statement = null;
        ResultSet result = null;
        Connection connecton = getConnection();
        statement = connecton.createStatement();
        //database tabellen inlezen
        result = statement.executeQuery("SELECT * FROM `gebruiker`");

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
            return new Gebruiker(id, naam, wachtwoord, isAdmin);
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