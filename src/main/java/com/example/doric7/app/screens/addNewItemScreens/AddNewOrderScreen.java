package com.example.doric7.app.screens.addNewItemScreens;

import com.example.doric7.controllers.addNewItemControllers.AddNewOrderController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddNewOrderScreen extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader =
                new FXMLLoader(AddNewOrderScreen.class.getResource("/com/example/doric7/addNewOrderScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        stage.setTitle("Add new Order Screen!");
        stage.setScene(scene);
        AddNewOrderController controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.show();
    }
}
