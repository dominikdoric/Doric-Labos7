package com.example.doric7.app.screens;

import com.example.doric7.controllers.CategoryScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CategoryScreen extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader =
                new FXMLLoader(CategoryScreen.class.getResource("/com/example/doric7/categoryScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        stage.setTitle("Category Screen!");
        stage.setScene(scene);
        CategoryScreenController categoryScreenController = fxmlLoader.getController();
        categoryScreenController.setStage(stage);
        stage.show();
    }
}
