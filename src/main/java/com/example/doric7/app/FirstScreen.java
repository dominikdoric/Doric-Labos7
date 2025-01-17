package com.example.doric7.app;

import com.example.doric7.controllers.FirstScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstScreen extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FirstScreen.class.getResource("/com/example/doric7/firstScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        FirstScreenController firstScreenController = fxmlLoader.getController();
        firstScreenController.setStage(stage);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}