package com.example.project2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class Login {


    @FXML
    private Button LogIn;

    @FXML
    private TextField Username;

    @FXML
    private PasswordField password;

    @FXML
    private Button wachtwoordReset;

    @FXML
    private Text wrongLogin;

    @FXML
    void login_Button(ActionEvent event) throws IOException{
        checkLogin();
    }

    @FXML
    void password_Input(ActionEvent event) {

    }

    @FXML
    void username_Input(ActionEvent event) {

    }

    @FXML
    void wachtwoordReset_button(ActionEvent event) throws IOException{
        HelloApplication h = new HelloApplication();
        h.changeScene("Dashboard.fxml");

    }

    private void checkLogin() throws IOException{
        HelloApplication h = new HelloApplication();
        if(Username.getText().toString().equals("a") && password.getText().toString().equals("a")) {
            h.changeScene("Dashboard.fxml");
        }

        else if(Username.getText().isEmpty() && password.getText().isEmpty()) {
            wrongLogin.setText("Vul uw gegevens in!");
//            wachtwoordReset.setVisible(true);
        }

        else {
            wrongLogin.setText("Verkeerde gebruikersnaam en/of wachtwoord!");
//            wachtwoordReset.setVisible(true);
        }
    }
}
