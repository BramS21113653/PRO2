package com.example.project2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
public class AdminPanel {

    @FXML
    private TextField gebruikersnaam_tekst;

    @FXML
    private TextField wachtwoord_tekst;

    @FXML
    private Button Dashboard;

    @FXML
    private TextField admin_tekst;

    @FXML
    private Button Gebruiker_toevoegen;

    @FXML
    private Button gebruiker_verwijderen;

    @FXML
    private ComboBox<?> verwijderen_combobox;

    @FXML
    void Dashboard_button(ActionEvent event) throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene("Dashboard.fxml");
    }

    @FXML
    void gebruiker_verwijderen(ActionEvent event) {

    }

    @FXML
    void Gebruiker_toevoegen(ActionEvent event) {

    }

    @FXML
    void verwijderen_combobox(ActionEvent event) {

    }

    @FXML
    void gebruikersnaam_tekst(ActionEvent event) {

    }

    @FXML
    void wachtwoord_tekst(ActionEvent event) {

    }

    @FXML
    void admin_tekst(ActionEvent event) {

    }
}
