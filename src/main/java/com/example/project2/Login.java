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
    private Text wrongLogin;

    @FXML
    void login_Button(ActionEvent event) throws IOException, SQLException {
        checkLogin();
    }

    @FXML
    void password_Input(ActionEvent event) {

    }

    @FXML
    void username_Input(ActionEvent event) {

    }
    

    private void checkLogin() throws IOException, SQLException {
        HelloApplication h = new HelloApplication();
        Gebruiker ingelogd = null;
        String uname = Username.getText();
        String passw = password.getText();
        Gebruiker.templateMethod();
        for (Gebruiker gebruiker : Gebruiker.getGebruikersLijst()) {
            if (Username.getText().equals(gebruiker.getNaam()) && password.getText().equals(gebruiker.getWachtwoord())) {
                ingelogd = gebruiker;
            } else if (Username.getText().isEmpty() && password.getText().isEmpty()) {
                wrongLogin.setText("Vul alle vakken in");
            } else {
                wrongLogin.setText("Wachtwoord of gebruikersnaam onjuist");
            }
        }
        Gebruiker.setIngelogdId(ingelogd);
        if (ingelogd != null) {
            h.changeScene("Dashboard.fxml");
        }
    }
}
