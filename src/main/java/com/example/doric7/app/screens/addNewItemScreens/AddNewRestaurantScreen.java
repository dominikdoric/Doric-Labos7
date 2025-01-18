package com.example.doric7.app.screens.addNewItemScreens;

import com.example.doric7.controllers.addNewItemControllers.AddNewRestaurantController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddNewRestaurantScreen extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader =
                new FXMLLoader(AddNewRestaurantScreen.class.getResource("/com/example/doric7/addNewRestaurantScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        stage.setTitle("Add new Restaurant Screen!");
        stage.setScene(scene);
        AddNewRestaurantController controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.show();
    }
}
