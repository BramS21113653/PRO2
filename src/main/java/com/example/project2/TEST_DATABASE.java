package com.example.project2;

import java.sql.*;

public class TEST_DATABASE {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/betabit", "root", "root");
            Statement stat = con.createStatement();
            String sql = "select * from gebruiker";
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                int id_col = rs.getInt("MedewerkerID");
                String DB_username = rs.getString("MedewerkerNaam");
                String DB_password = rs.getString("MedewerkerWachtwoord");
                String DB_bedrijf = rs.getString("Bedrijf");


                String p = id_col + " " + DB_username + " " + DB_password + " " + DB_bedrijf;
                System.out.println(p);
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }
}