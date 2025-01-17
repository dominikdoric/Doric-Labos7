package com.example.doric7.app.screens;

import com.example.doric7.controllers.MealsScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MealsScreen extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader =
                new FXMLLoader(MealsScreen.class.getResource("/com/example/doric7/mealsScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        stage.setTitle("Meals Screen!");
        stage.setScene(scene);
        MealsScreenController controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.show();
    }
}
