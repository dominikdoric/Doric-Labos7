package com.example.doric7.app.screens.searchScreens;

import com.example.doric7.controllers.searchControllers.ContractsScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ContractsScreen extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader =
                new FXMLLoader(ContractsScreen.class.getResource("/com/example/doric7/contractsScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        stage.setTitle("Contracts Screen!");
        stage.setScene(scene);
        ContractsScreenController controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.show();
    }
}
