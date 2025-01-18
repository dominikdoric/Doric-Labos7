package com.example.doric7.app.screens.addNewItemScreens;

import com.example.doric7.controllers.addNewItemControllers.AddNewWaiterController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddNewWaiterScreen extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader =
                new FXMLLoader(AddNewWaiterScreen.class.getResource("/com/example/doric7/addNewWaiterScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        stage.setTitle("Add new Waiter Screen!");
        stage.setScene(scene);
        AddNewWaiterController controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.show();
    }
}
