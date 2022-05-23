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
    private TableColumn<?, ?> colomNaam;

    @FXML
    private TableColumn<?, ?> colomPlaats;

    @FXML
    private TableColumn<?, ?> colomPunten;

    @FXML
    private Button confirm;

    @FXML
    private ChoiceBox<?> keuze_Menu;

    @FXML
    private Button logOut;

    @FXML
    private TableView<?> tabelGegevens;

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

}
