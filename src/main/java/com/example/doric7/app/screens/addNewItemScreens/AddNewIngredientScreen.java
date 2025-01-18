package com.example.doric7.app.screens.addNewItemScreens;

import com.example.doric7.controllers.addNewItemControllers.AddNewIngredientController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddNewIngredientScreen extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader =
                new FXMLLoader(AddNewIngredientScreen.class.getResource("/com/example/doric7/addNewIngredientScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        stage.setTitle("Add new Ingredient Screen!");
        stage.setScene(scene);
        AddNewIngredientController controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.show();
    }
}
