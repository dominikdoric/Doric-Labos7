package com.example.doric7.app.screens.addNewItemScreens;

import com.example.doric7.controllers.addNewItemControllers.AddNewDelivererScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddNewDelivererScreen extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader =
                new FXMLLoader(AddNewCategoryScreen.class.getResource("/com/example/doric7/addNewDelivererScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        stage.setTitle("Add new Deliverer Screen!");
        stage.setScene(scene);
        AddNewDelivererScreenController controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.show();
    }
}
