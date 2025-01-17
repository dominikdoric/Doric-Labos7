package com.example.doric7.app.screens;

import com.example.doric7.controllers.DelivererScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DelivererScreen extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DelivererScreen.class.getResource("/com/example/doric7/deliverersScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        stage.setTitle("Deliverers Screen!");
        stage.setScene(scene);
        DelivererScreenController delivererScreenController = fxmlLoader.getController();
        delivererScreenController.setStage(stage);
        stage.show();
    }
}
