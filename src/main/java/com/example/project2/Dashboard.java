package com.example.project2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.IOException;

public class Dashboard {

    @FXML
    private TextField KilometersInput;

    @FXML
    private TableColumn<Table, String> colomNaam;

    @FXML
    private TableColumn<Table, Integer> colomPlaats;

    @FXML
    private TableColumn<Table, Integer> colomPunten;

    @FXML
    private Button confirmButton;

    @FXML
    private ChoiceBox<?> keuze_Menu;

    @FXML
    private Button logOut;

    @FXML
    private TableView<Table> tabelGegevens;

    @FXML
    private Button adminButton;

    @FXML
    private Text wrongInput;

    @FXML
    void Confirm_button(ActionEvent event) {
        try {
            double input = Double.parseDouble(KilometersInput.getText().replaceAll(",","."));
        } catch (Exception e) {
//            wrongInput.setText("Graag goede input geven!");
            System.out.println("Verkeerde input");
        }
    }

    @FXML
    void Kilometers_Input(ActionEvent event) {

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
}
