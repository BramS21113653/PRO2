package com.example.project2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private static Stage stg;

    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("BetaBit");
        stage.setScene(scene);
        stage.show();
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
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