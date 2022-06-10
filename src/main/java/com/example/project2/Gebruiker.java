package com.example.project2;

import java.util.*;
import java.sql.*;

public class Gebruiker {
    private Integer id;
    private String naam;
    private String wachtwoord;
    private Integer isAdmin;
    private Integer punten;
    private Integer plaats;
    private ArrayList<Rit> ritten = new ArrayList<Rit>();
    public static ArrayList<Gebruiker> gebruikerslijst = new ArrayList<Gebruiker>();

    public Gebruiker(Integer id, String naam, String wachtwoord, Integer isAdmin, Integer punten, Integer plaats, Boolean insert) throws SQLException {
        this.id = id;
        this.naam = naam;
        this.wachtwoord = wachtwoord;
        this.isAdmin = isAdmin;
        this.punten = punten;
        this.plaats = plaats;
        if (insert == true) {
            insertGebruiker();
            refreshGebruikerslijst();
        } else {

            gebruikerslijst.add(this);
        }
    }

    public void insertGebruiker() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/betabit", "root", "");
        Statement stat = connection.createStatement();
        String query = " insert into gebruiker (id, naam, wachtwoord, isadmin, punten)"
                + " values (?, ?, ?, ?, ?)";
        Random rand = new Random();
        Integer int_random = rand.nextInt(99999999);
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setInt (1,int_random);
        preparedStmt.setString (2, this.naam);
        preparedStmt.setString   (3, this.wachtwoord);
        preparedStmt.setInt(4, this.isAdmin);
        preparedStmt.setInt(5, this.punten);
        preparedStmt.execute();
        connection.close();
    }

    public static void refreshGebruikerslijst() throws SQLException {
        gebruikerslijst.clear();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/betabit", "root", "");
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM `gebruiker` ORDER BY `punten` DESC");
        Integer counter = 0;
        try {
            while (result.next()) {
                counter ++;
                Gebruiker gebruiker = getGebruikerFromResult(result, counter);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static Gebruiker getGebruikerFromResult(ResultSet result, Integer counter){
        try {
            Integer id = result.getInt("id");
            String naam = result.getString("naam");
            String wachtwoord = result.getString("wachtwoord");
            Integer isAdmin = result.getInt("isadmin");
            Integer punten = result.getInt("punten");
            return new Gebruiker(id, naam, wachtwoord, isAdmin, punten, counter,false);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    public static ArrayList<Gebruiker> getGebruikersLijst() {return gebruikerslijst;}

    public String getNaam() {return naam;}

    public Integer getId() {return id;}

    public Integer getIsAdmin() {return isAdmin;}

    public Integer getPunten() {return punten;}

    public Integer getPlaats() {return plaats;}

    public void setPlaats(Integer plaats) {this.plaats = plaats;}

    public void addRit(Rit rit) {
        this.ritten.add(rit);
    }

    public Gebruiker getGebruikerOnId(Integer id) {
        Gebruiker match = null;
        for (Gebruiker gebruiker : gebruikerslijst){
            if (gebruiker.getId().equals(id)) {
                match = gebruiker;
            }
        }
        return match;
    }
    public static void deleteGebruikerOnId(Integer id) throws SQLException {
        if (id != null) {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/betabit", "root", "");
            PreparedStatement statement = connection.prepareStatement(" DELETE FROM gebruiker WHERE id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    @Override
    public String toString() {
        return  "Naam = " + naam + "\n" +
                "Ritten = " + ritten + "\n" +
                "IsAdmin = " + isAdmin + "\n";
    }
}

