package com.example.project2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class AdminPanel implements Initializable {

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
    private ComboBox<String> verwijderen_combobox;

    @FXML
    void Dashboard_button(ActionEvent event) throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene("Dashboard.fxml");
    }

    @FXML
    void gebruiker_verwijderen(ActionEvent event) throws SQLException {
        try {
            String idString = verwijderen_combobox.getValue().replaceAll("[^0-9]", "");
            Integer id = parseInt(idString);
            Admin.deleteGebruikerOnId(id);
            Gebruiker.refreshGebruikerslijst();
            refreshbox();
        } catch(Exception e) {

        }
    }

    @FXML
    void Gebruiker_toevoegen(ActionEvent event) throws SQLException {
        try {
            Integer isadmin = parseInt(admin_tekst.getText());
            String gebruikersnaam = gebruikersnaam_tekst.getText();
            String wachtwoord = wachtwoord_tekst.getText();
            if (isadmin == 0) {
                Gebruiker gebruiker = new Client(0, gebruikersnaam, wachtwoord, 0, 0, true);
            } else {
                Gebruiker gebruiker = new Admin(0, gebruikersnaam, wachtwoord, 0, 0, true);
            }

        } catch(Exception e) {
            gebruikersnaam_tekst.setPromptText("Vul nieuwe gebruiker in");
            wachtwoord_tekst.setPromptText("Vul wachtwoord in");
            admin_tekst.setPromptText("Kies een 0/1");

        }
        admin_tekst.setText("");
        wachtwoord_tekst.setText("");
        gebruikersnaam_tekst.setText("");
        refreshbox();
        Gebruiker.refreshGebruikerslijst();
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

    private void refreshbox() {
        verwijderen_combobox.setValue("");
        verwijderen_combobox.getItems().clear();
        for (Gebruiker gebruiker : Gebruiker.getGebruikersLijst()) {
            if (gebruiker instanceof Admin) {
                verwijderen_combobox.getItems().add(gebruiker.getNaam() + " | " + gebruiker.getId() + " | ADMIN");
            } else {
                verwijderen_combobox.getItems().add(gebruiker.getNaam() + " | " + gebruiker.getId());
            }
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        refreshbox();
    }
}
