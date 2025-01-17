package com.example.doric7.app.screens;

import com.example.doric7.controllers.IngredientScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class IngredientScreen extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader =
                new FXMLLoader(IngredientScreen.class.getResource("/com/example/doric7/ingredientsScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        IngredientScreenController ingredientsScreenController = fxmlLoader.getController();
        ingredientsScreenController.setStage(stage);
        stage.show();
    }
}
