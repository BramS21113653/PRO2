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

import static java.lang.Integer.parseInt;

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
    private Label dashboard_title;

    @FXML
    private Button dashboard_verzilveren;
    @FXML
    private ImageView footprint1;
    @FXML
    private ImageView footprint2;
    @FXML
    private ImageView footprint3;
    @FXML
    private ImageView footprint4;
    @FXML
    private ImageView footprint5;

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
    void dashboard_verzilveren(ActionEvent event) throws SQLException {
        Gebruiker.getIngelogdId().setPunten(0);
        Gebruiker.resetPunten();
        refreshDash();
        setcolor();
    }

    @FXML
    void Confirm_button(ActionEvent event) throws SQLException {
        try {
            double multiplier =0.0;
            for (Vervoersmiddel vervoersmiddel : Vervoersmiddel.getVervoersmiddelen()) {
                if (vervoersmiddel.getVervoersmiddel().equals(keuze_Menu.getValue())) {
                    multiplier = vervoersmiddel.getMultiplier();
                }
            }
            if (parseInt(kilometer_field.getText()) > 50) {
                kilometer_field.setText("50");
            }
            Gebruiker.getIngelogdId().addPunten((int) Math.round(parseInt(kilometer_field.getText()) * multiplier));
            kilometer_field.setText("");
        } catch(Exception e) {
            System.out.println(e.getMessage());
            kilometer_field.setPromptText("Voer aantal kilomter in");
        }
        setcolor();
        refreshDash();
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
        if (Gebruiker.getIngelogdId().getIsAdmin() != 0) {
            h.changeScene("AdminPanel.fxml");
        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            refreshDash();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            setcolor();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void refreshDash() throws SQLException {
        Gebruiker.refreshGebruikerslijst();

        ObservableList<Gebruiker> list = FXCollections.observableArrayList(Gebruiker.getGebruikersLijst());
        keuze_Menu.getItems().setAll("Lopen", "Ov", "Fiets", "Motor", "Scooter", "Elektrische Auto", "Diesel Auto", "Benzine Auto");
        colomNaam.setCellValueFactory(new PropertyValueFactory<Gebruiker, String>("naam"));
        colomPunten.setCellValueFactory(new PropertyValueFactory<Gebruiker, Integer>("punten"));
        colomPlaats.setCellValueFactory(new PropertyValueFactory<Gebruiker, Integer>("plaats"));
        tabelGegevens.getItems().removeAll();
        tabelGegevens.setItems(list);
    }
    private void setcolor() throws SQLException {
        adminButton.setStyle("-fx-border-color: linear-gradient(#bc0000, #f50c0c);");
        footprint1.setVisible(true);
        footprint2.setVisible(false);
        footprint3.setVisible(false);
        footprint4.setVisible(false);
        footprint5.setVisible(false);
        if (Gebruiker.getIngelogdId().getPunten() <= 50) {
            footprint1.setVisible(true);
            dashboard_title.setStyle("-fx-background-color: #0dbc00; -fx-background-radius: 0 0 20 20; -fx-border-color: linear-gradient(#0dbc00, #1ae20c); -fx-border-width: 6; -fx-border-radius: 0 0 20 20; -fx-border-style: solid;");
            dashboard_verzilveren.setStyle("-fx-border-color: linear-gradient(#0dbc00, #1ae20c);");
        } else if (Gebruiker.getIngelogdId().getPunten() <= 100) {
            footprint2.setVisible(true);
            dashboard_title.setStyle("-fx-background-color: #9fbc00; -fx-background-radius: 0 0 20 20; -fx-border-color: linear-gradient(#9fbc00, #cef209); -fx-border-width: 6; -fx-border-radius: 0 0 20 20; -fx-border-style: solid;");
            dashboard_verzilveren.setStyle("-fx-border-color: linear-gradient(#9fbc00, #cef209);");
        } else if (Gebruiker.getIngelogdId().getPunten() <= 150) {
            footprint3.setVisible(true);
            dashboard_title.setStyle("-fx-background-color: #bcb100; -fx-background-radius: 0 0 20 20; -fx-border-color: linear-gradient(#bcb100, #e8db0c); -fx-border-width: 6; -fx-border-radius: 0 0 20 20; -fx-border-style: solid;");
            dashboard_verzilveren.setStyle("-fx-border-color: linear-gradient(#bcb100, #e8db0c);");
        } else if (Gebruiker.getIngelogdId().getPunten() <= 200) {
            footprint4.setVisible(true);
            dashboard_title.setStyle("-fx-background-color: #bc6a00; -fx-background-radius: 0 0 20 20; -fx-border-color: linear-gradient(#bc6a00, #f68d05); -fx-border-width: 6; -fx-border-radius: 0 0 20 20; -fx-border-style: solid;");
            dashboard_verzilveren.setStyle("-fx-border-color: linear-gradient(#bc6a00, #f68d05);");
        } else if (Gebruiker.getIngelogdId().getPunten() >= 250) {
            footprint5.setVisible(true);
            dashboard_title.setStyle("-fx-background-color: #bc0000; -fx-background-radius: 0 0 20 20; -fx-border-color: linear-gradient(#bc0000, #f50c0c); -fx-border-width: 6; -fx-border-radius: 0 0 20 20; -fx-border-style: solid;");
            dashboard_verzilveren.setStyle("-fx-border-color: linear-gradient(#bc0000, #f50c0c);");
        }
    }
}
