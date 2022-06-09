package com.example.project2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Dashboard implements Initializable {

    @FXML
    private TableColumn colomNaam;

    @FXML
    private TableColumn colomPlaats;

    @FXML
    private TableColumn colomPunten;

    @FXML
    private Button confirmButton;

    @FXML
    private ComboBox keuze_Menu;

    @FXML
    private Button logOut;

    @FXML
    private TableView tabelGegevens;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        keuze_Menu.getItems().addAll("Lopen", "Ov", "Fiets", "Motor", "Scooter");
//        keuze_Menu.getItems().add("Items 5");
    }


    public void haalvervoersmiddelop(){
        for (Vervoersmiddel vervoersmiddel : Vervoersmiddel.getVervoersmiddelen()){
            System.out.println("hi");
        }
    }
}
