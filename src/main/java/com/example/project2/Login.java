package com.example.project2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.*;


public class Login {


    @FXML
    private Button LogIn;

    @FXML
    private TextField Username;

    @FXML
    private PasswordField password;

    @FXML
    private Button wachtwoordReset;

    @FXML
    private Text wrongLogin;

    @FXML
    void login_Button(ActionEvent event) throws IOException{
        checkLogin();
    }

    @FXML
    void password_Input(ActionEvent event) {

    }

    @FXML
    void username_Input(ActionEvent event) {

    }

    @FXML
    void wachtwoordReset_button(ActionEvent event) throws IOException{
        HelloApplication h = new HelloApplication();
        h.changeScene("Dashboard.fxml");

    }

    private void checkLogin() throws IOException{
        HelloApplication h = new HelloApplication();
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/betabit", "root", "root");
            Statement stat = con.createStatement();
            String sql = "select * from betabit.gebruiker";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                int id_col = rs.getInt("id");
                String DB_username = rs.getString("naam");
                String DB_password = rs.getString("wachtwoord");
                int isadmin = rs.getInt("isadmin");
                if (Username.getText().toString().equals(DB_username) && password.getText().toString().equals(DB_password)) {
                    h.changeScene("Dashboard.fxml");
                } else if (Username.getText().isEmpty() && password.getText().isEmpty()) {
                    wrongLogin.setText("Please enter your data.");
                } else {
                    wrongLogin.setText("Wrong username or password!");
                }
            }

        } catch (Exception error){
            System.out.println(error.getMessage());
        }
    }
}
