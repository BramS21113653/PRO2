package com.example.project2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class AdminPanel {

    @FXML
    private Button Dashboard;

    @FXML
    void Dashboard_button(ActionEvent event) throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene("Dashboard.fxml");
    }
}
