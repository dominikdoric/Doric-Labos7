package com.example.doric7.app.screens.searchScreens;

import com.example.doric7.controllers.searchControllers.RestaurantScreenController;
import com.example.doric7.models.Restaurant;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RestaurantScreen extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader =
                new FXMLLoader(Restaurant.class.getResource("/com/example/doric7/restaurantsScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        stage.setTitle("Restaurants Screen!");
        stage.setScene(scene);
        RestaurantScreenController controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.show();
    }
}
