package com.example.project2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class HelloApplication extends Application {

    private static Stage stg;

    @Override
    public void start(Stage stage) throws IOException, SQLException {
        Vervoersmiddel benzineAuto = new Vervoersmiddel("Benzine Auto", 1.0);
        Vervoersmiddel dieselAuto = new Vervoersmiddel("Diesel Auto", 1.1);
        Vervoersmiddel elektrischeAuto = new Vervoersmiddel("Elektrische Auto", 0.5);
        Vervoersmiddel scooter = new Vervoersmiddel("Scooter", 0.8);
        Vervoersmiddel motor = new Vervoersmiddel("Motor", 1.0);
        Vervoersmiddel fiets = new Vervoersmiddel("Fiets", 0.1);
        Vervoersmiddel ov = new Vervoersmiddel("Ov", 0.2);
        Vervoersmiddel lopen = new Vervoersmiddel("Lopen", 0);
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
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) throws SQLException {
        launch();
    }
}