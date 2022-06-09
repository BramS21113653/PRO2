package com.example.project2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class AdminPanel {

    @FXML
    private Button Dashboard;

    @FXML
    private Button Gebruiker_toevoegen;

    @FXML
    private Button Gebruiker_verwijderen;
    @FXML
    void Dashboard_button(ActionEvent event) throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene("Dashboard.fxml");
    }

    @FXML
    void Gebruiker_verwijderen(ActionEvent event) {

    }

    @FXML
    void Gebruiker_toevoegen(ActionEvent event) {

    }
}
