package com.example.doric7.app.screens.addNewItemScreens;

import com.example.doric7.controllers.addNewItemControllers.AddNewContractController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddNewContractScreen  extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader =
                new FXMLLoader(AddNewContractController.class.getResource("/com/example/doric7/addNewContractScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        stage.setTitle("Add new Contract Screen!");
        stage.setScene(scene);
        AddNewContractController controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.show();
    }
}
