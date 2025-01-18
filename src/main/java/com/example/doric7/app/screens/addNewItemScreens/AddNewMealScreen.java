package com.example.doric7.app.screens.addNewItemScreens;

import com.example.doric7.controllers.addNewItemControllers.AddNewMealController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddNewMealScreen extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader =
                new FXMLLoader(AddNewMealScreen.class.getResource("/com/example/doric7/addNewMealScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        stage.setTitle("Add new Meal Screen!");
        stage.setScene(scene);
        AddNewMealController controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.show();
    }
}
