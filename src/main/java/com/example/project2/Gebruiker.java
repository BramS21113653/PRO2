package com.example.project2;

// template method pattern

import java.util.*;
import java.sql.*;
import com.example.project2.*;


public abstract class Gebruiker {
    protected static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/betabit", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected Integer id;
    protected String naam;
    protected String wachtwoord;
    protected Integer punten;
    protected Integer plaats;
    protected static Gebruiker ingelogdId;
    public static ArrayList<Gebruiker> gebruikerslijst = new ArrayList<Gebruiker>();

    public Gebruiker(Integer id, String naam, String wachtwoord, Integer punten, Integer plaats, Boolean insert) throws SQLException {
        this.id = id;
        this.naam = naam;
        this.wachtwoord = wachtwoord;
        this.punten = punten;
        this.plaats = plaats;
        if (insert == true) {

        } else {
            gebruikerslijst.add(this);
        }
    }

    public static void resetPunten() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(" UPDATE gebruiker SET punten = ?");
        statement.setInt(1, 0);
        statement.executeUpdate();
        refreshGebruikerslijst();
    }

    public static void refreshGebruikerslijst() throws SQLException {
        gebruikerslijst.clear();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `gebruiker` ORDER BY `punten`");

            Integer counter = 0;

            while (result.next()) {
                counter ++;
                Gebruiker gebruiker = getGebruikerFromResult(result, counter);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (connection != null) {
            }
        }


    }
    public static Gebruiker getGebruikerFromResult(ResultSet result, Integer counter){
        try {
            Integer id = result.getInt("id");
            String naam = result.getString("naam");
            String wachtwoord = result.getString("wachtwoord");
            Integer isAdmin = result.getInt("isadmin");
            Integer punten = result.getInt("punten");
            if (isAdmin == 1) {
                return new Admin(id, naam, wachtwoord, punten, counter, false);
            }
            else {
                return new Client(id, naam, wachtwoord, punten, counter,false);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static ArrayList<Gebruiker> getGebruikersLijst() {return gebruikerslijst;}

    public String getNaam() {return naam;}

    public Integer getId() {return id;}

    public Integer getPunten() {return punten;}

    public void setPunten(Integer punten) {
        this.punten = punten;
    }

    public void addPunten(Integer punten) throws SQLException {
        Integer waarde;
        waarde = this.punten + punten;
        this.punten = waarde;
        try {
            PreparedStatement statement = connection.prepareStatement(" UPDATE gebruiker SET punten = ? WHERE id=?");
            statement.setInt(1, waarde);
            statement.setInt(2, ingelogdId.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert connection != null;
        }

    }

    public Integer getPlaats() {return plaats;}

    public void setPlaats(Integer plaats) {this.plaats = plaats;}


    public static Gebruiker getIngelogdId() {
        return ingelogdId;
    }

    public static void setIngelogdId(Gebruiker ingelogdId) {
        Gebruiker.ingelogdId = ingelogdId;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public static Gebruiker getGebruikerOnId(Integer id) {
        Gebruiker match = null;
        for (Gebruiker gebruiker : gebruikerslijst){
            if (gebruiker.getId().equals(id)) {
                match = gebruiker;
                break;
            }
        }
        return match;
    }

    public abstract String getTitel();

    @Override
    public String toString() {
        return getTitel() + "{"+
                "id=" + id +
                ", naam='" + naam + '\'' +
                ", wachtwoord='" + wachtwoord + '\'' +
                ", punten=" + punten +
                ", plaats=" + plaats +
                '}';
    }
}

