package com.example.tekstivari;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TekstiVaihto extends Application {
    public void start(Stage stage) {
        Button button = new Button("Ohjelmointi on kivaa");
        button.setStyle("-fx-text-fill: black");
        button.setFont(Font.font(20));

        EventHandler<ActionEvent> tapahtumankasittelija = e -> {
                button.setOnMouseClicked(a -> {
                    if(a.getButton() == MouseButton.PRIMARY) {
                        button.setStyle("-fx-text-fill: red");
                    }
                    if(a.getButton() == MouseButton.SECONDARY) {
                        button.setStyle("-fx-text-fill: blue");
                    }
                });
                button.setOnKeyPressed(d -> {
                    if(d.getEventType() == KeyEvent.KEY_PRESSED) {
                        button.setStyle("-fx-text-fill: black");
                    }
                });
        };
        Timeline animaatio = new Timeline(
                new KeyFrame(Duration.millis(500), tapahtumankasittelija));
        animaatio.setCycleCount(Timeline.INDEFINITE);
        animaatio.play();
        Scene scene = new Scene(button, 320, 240);
        stage.setTitle("Hiiriteksti");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}