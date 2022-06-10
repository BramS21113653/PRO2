package com.example.project2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
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
    private ImageView dashboard_image;

    @FXML
    private ComboBox keuze_Menu;

    @FXML
    private TextField kilometer_field;

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
        try {
            double input = Double.parseDouble(kilometer_field.getText().replaceAll(",","."));
            System.out.println(input);
        } catch (Exception e) {
            System.out.println("Verkeerde input");
        }
    }

    @FXML
    void Kilometer_Input(ActionEvent event) {
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
        ObservableList<Gebruiker> list = FXCollections.observableArrayList(Gebruiker.getGebruikersLijst());
        keuze_Menu.getItems().addAll("Lopen", "Ov", "Fiets", "Motor", "Scooter", "Elektrische Auto", "Diesel Auto", "Benzine Auto");
        colomNaam.setCellValueFactory(new PropertyValueFactory<Gebruiker, String>("naam"));
        colomPunten.setCellValueFactory(new PropertyValueFactory<Gebruiker, Integer>("punten"));
        colomPlaats.setCellValueFactory(new PropertyValueFactory<Gebruiker, Integer>("plaats"));
        tabelGegevens.getItems().removeAll();
        tabelGegevens.setItems(list);
    }
}
