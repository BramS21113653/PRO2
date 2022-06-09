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
    Gebruiker gebruiker = new Gebruiker( 1, "Niels", "wachtwoord", 1, 10);
    ObservableList<Gebruiker> list = FXCollections.observableArrayList(Gebruiker.getGebruikersLijst());
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        keuze_Menu.getItems().addAll("Lopen", "Ov", "Fiets", "Motor", "Scooter");
        colomNaam.setCellValueFactory(new PropertyValueFactory<Gebruiker, String>("naam"));
        colomPunten.setCellValueFactory(new PropertyValueFactory<Gebruiker, Integer>("punten"));
        colomPlaats.setCellValueFactory(new PropertyValueFactory<Gebruiker, Integer>("id"));

        tabelGegevens.setItems(list);
    }


    public void haalvervoersmiddelop(){
        for (Vervoersmiddel vervoersmiddel : Vervoersmiddel.getVervoersmiddelen()){
            System.out.println("hi");
        }
    }
}
