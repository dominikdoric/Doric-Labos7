package com.example.doric7.app.screens;

import com.example.doric7.controllers.ChefsScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChefsScreen extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader =
                new FXMLLoader(ChefsScreen.class.getResource("/com/example/doric7/chefsScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        stage.setTitle("Chefs Screen!");
        stage.setScene(scene);
        ChefsScreenController controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.show();
    }
}
