package com.example.project2;
import java.sql.*;
import java.util.*;

public class Rit {
    private Integer id;
    private Integer gebruikersid;
    private String vervoersmiddel;
    private Integer afstand;
    public static ArrayList<Rit> ritten = new ArrayList<Rit>();
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

    public Rit(Integer id, Integer gebruikersid, String vervoersmiddel, Integer afstand){
        this.id = id;
        this.gebruikersid = gebruikersid;
        this.vervoersmiddel = vervoersmiddel;
        this.afstand = afstand;
    }

    public Rit(Integer id, Integer gebruikersid, String vervoersmiddel, Integer afstand, boolean insert) throws SQLException {
        this.id = id;
        this.gebruikersid = gebruikersid;
        this.vervoersmiddel = vervoersmiddel;
        this.afstand = afstand;
        insertRit();
        refreshRitten();
    }


    public void insertRit() throws SQLException {
        Connection connecton = getConnection();
        String query = " insert into rit (id, gebruikersid, vervoersmiddel, afstand, datetime)"
                + " values (?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt = connecton.prepareStatement(query);
        preparedStmt.setInt (2, this.gebruikersid);
        preparedStmt.setString   (3, this.vervoersmiddel);
        preparedStmt.setInt(4, this.afstand);

        preparedStmt.execute();

        connecton.close();
    }

    public void refreshRitten() throws SQLException {
        //ritten legen
        ritten.clear();
        Statement statement = null;
        ResultSet result = null;
        Connection connecton = getConnection();
        statement = connecton.createStatement();
        //database tabellen inlezen
        result = statement.executeQuery("SELECT * FROM `rit`");

        try {
            while (result.next()) {
                //ritten maken van database gegevens
                Rit rit = getRitFromResult(result);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public static Rit getRitFromResult(ResultSet result){
        try {
            Integer id = result.getInt("id");
            Integer gebruikersid = result.getInt("gebruikersid");
            String vervoersmiddel = result.getString("vervoersmiddel");
            Integer afstand = result.getInt("afstand");
            return new Rit(id, gebruikersid, vervoersmiddel, afstand);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
