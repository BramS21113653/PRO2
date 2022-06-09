package com.example.project2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Dashboard<list> implements Initializable {

    @FXML
    private TableColumn<Gebruiker, String> colomNaam;

    @FXML
    private TableColumn<Gebruiker, Integer> colomPlaats;

    @FXML
    private TableColumn<Gebruiker, Integer> colomPunten;

    @FXML
    private Button confirmButton;

    @FXML
    private ComboBox keuze_Menu;

    @FXML
    private Button logOut;

    @FXML
    private TableView<Gebruiker> tabelGegevens;

    @FXML
    private Button adminButton;

    public Dashboard() throws SQLException {
    }

    @FXML
    void Confirm_button(ActionEvent event) {
    }

    @FXML
    void logOut_Button(ActionEvent event) throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene("Login.fxml");
    }

    @FXML
    void totale_Tabel(ActionEvent event) {

    }

    @FXML
    void Admin_button(ActionEvent event) throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene("AdminPanel.fxml");
    }

    Gebruiker gebruiker1 = new Gebruiker( 1, "Niels", "wachtwoord", 1, 10, false);
    Gebruiker gebruiker2 = new Gebruiker( 2, "Daniel", "wachtwoord", 1, 8, false);
    Gebruiker gebruiker3 = new Gebruiker( 3, "Rick", "wachtwoord", 1, 7, false);
    Gebruiker gebruiker4 = new Gebruiker( 4, "Bram", "wachtwoord", 1, 4, false);
    Gebruiker gebruiker5 = new Gebruiker( 5, "Luc", "wachtwoord", 1, 1, false);

    ObservableList<Gebruiker> list = FXCollections.observableArrayList(Gebruiker.getGebruikersLijst());

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        keuze_Menu.getItems().addAll("Lopen", "Ov", "Fiets", "Motor", "Scooter", "Elektrische Auto", "Diesel Auto", "Benzine Auto");
        colomNaam.setCellValueFactory(new PropertyValueFactory<Gebruiker, String>("naam"));
        colomPunten.setCellValueFactory(new PropertyValueFactory<Gebruiker, Integer>("punten"));
        colomPlaats.setCellValueFactory(new PropertyValueFactory<Gebruiker, Integer>("id"));
        tabelGegevens.getItems().removeAll();
        tabelGegevens.setItems(list);
    }
}
