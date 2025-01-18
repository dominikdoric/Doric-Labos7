package com.example.doric7.app.screens.searchScreens;

import com.example.doric7.controllers.searchControllers.OrdersScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OrdersScreen extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader =
                new FXMLLoader(OrdersScreen.class.getResource("/com/example/doric7/ordersScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        stage.setTitle("Orders Screen!");
        stage.setScene(scene);
        OrdersScreenController controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.show();
    }
}
