package com.example.project2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {

    private static Stage stg;

    @Override
    public void start(Stage stage) throws IOException, SQLException {
        Gebruiker gebruiker1 = new Gebruiker(1, "Niels", "wachtwoord", 1, 10, false);
        Gebruiker gebruiker2 = new Gebruiker(2, "Daniel", "wachtwoord", 1, 8, false);
        Gebruiker gebruiker3 = new Gebruiker(3, "Rick", "wachtwoord", 1, 7, false);
        Gebruiker gebruiker4 = new Gebruiker(4, "Bram", "wachtwoord", 1, 4, false);
        Gebruiker gebruiker5 = new Gebruiker(5, "Luc", "wachtwoord", 1, 1, false);
        stg = stage;
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("BetaBit");

        Image image = new Image("https://imgur.com/q4aD4K8.png");
        stage.getIcons().add(image);

        stage.setScene(scene);
        stage.show();
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) throws SQLException {
        launch();
        Vervoersmiddel benzineAuto = new Vervoersmiddel("benzine auto", 2269);
        Vervoersmiddel dieselAuto = new Vervoersmiddel("diesel auto", 2606);
        //todo uitstootPerLiter aanpassen hieronder
        Vervoersmiddel elektrischeAuto = new Vervoersmiddel("elektrische auto", 0);
        Vervoersmiddel scooter = new Vervoersmiddel("scooter", 2269);
        Vervoersmiddel motor = new Vervoersmiddel("motor", 2269);
        Vervoersmiddel fiets = new Vervoersmiddel("fiets", 0);
        //todo uitstootPerLiter aanpassen hieronder
        Vervoersmiddel ov = new Vervoersmiddel("ov", 0);
        Vervoersmiddel lopen = new Vervoersmiddel("lopen", 0);
    }
}