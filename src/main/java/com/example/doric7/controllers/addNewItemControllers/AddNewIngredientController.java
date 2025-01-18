package com.example.doric7.controllers.addNewItemControllers;

import com.example.doric7.app.screens.addNewItemScreens.AddNewIngredientScreen;
import com.example.doric7.controllers.searchControllers.*;
import com.example.doric7.models.Category;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import static com.example.doric7.app.Main.getCategoriesFromFile;

public class AddNewIngredientController {
    @FXML
    private TextField name;
    @FXML
    private TextField kcal;
    @FXML
    private TextField preparationMethod;
    @FXML
    private ComboBox<Category> categoryComboBox;
    @FXML
    private Button saveIngredientButton;

    private Stage stage;
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void initialize() {
        populateCategoryComboBox();
        saveIngredientButton.setOnAction(event -> onSaveIngredientClick());
    }

    private void populateCategoryComboBox() {
        List<Category> categories = getCategoriesFromFile();
        categoryComboBox.setItems(FXCollections.observableArrayList(categories));
        // Set a StringConverter to display the category name
        categoryComboBox.setConverter(new StringConverter<>() {
            @Override
            public String toString(Category category) {
                return category != null ? category.getName() : "";
            }

            @Override
            public Category fromString(String string) {
                // Not needed in this context
                return null;
            }
        });

        // Optionally set a default placeholder
        categoryComboBox.setPromptText("Select a Category");

    }

    @FXML
    public void onSaveIngredientClick() {
        String ingredientName = name.getText().trim();
        String ingredientKcal = kcal.getText().trim();
        String ingredientPreparationMethod = preparationMethod.getText().trim();
        Category selectedCategory = categoryComboBox.getSelectionModel().getSelectedItem();

        // Validate kcal as a numeric value
        BigDecimal kcalValue;
        try {
            kcalValue = new BigDecimal(ingredientKcal);
            if (kcalValue.compareTo(BigDecimal.ZERO) < 0) {
                throw new NumberFormatException("Kcal value cannot be negative.");
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Calories Value");
            alert.setContentText("Please enter a valid positive numeric value for calories.");
            alert.showAndWait();
            return;
        }

        // Check other fields
        if (ingredientName.isEmpty() || ingredientPreparationMethod.isEmpty() || selectedCategory == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Missing Information");
            alert.setContentText("Please fill in all fields and select a category.");
            alert.showAndWait();
            return;
        }

        try {
            String filePath = "dat/ingredients.txt";

            // Calculate the next ID
            int nextId = calculateNextId(filePath);

            // Construct the new ingredient entry
            StringBuilder newIngredientEntry = new StringBuilder();
            newIngredientEntry.append(nextId).append(System.lineSeparator()) // ID
                    .append(ingredientName).append(System.lineSeparator()) // Name
                    .append(selectedCategory.getId()).append(System.lineSeparator()) // Category ID
                    .append(kcalValue).append(System.lineSeparator()) // Calories (as BigDecimal)
                    .append(ingredientPreparationMethod).append(System.lineSeparator()); // Preparation Method

            // Append the new ingredient to the file
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.APPEND)) {
                writer.write(newIngredientEntry.toString());
            }

            // Clear the input fields
            name.clear();
            kcal.clear();
            preparationMethod.clear();
            categoryComboBox.getSelectionModel().clearSelection();
            System.out.println("Ingredient saved successfully!");

        } catch (IOException e) {
            System.err.println("Error saving ingredient: " + e.getMessage());
        }
    }

    private int calculateNextId(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            if (!lines.isEmpty()) {
                // Get the last ID from the file
                String lastIdLine = lines.get(lines.size() - 5); // Adjust for 5 lines per entry
                return Integer.parseInt(lastIdLine.trim()) + 1;
            }
        } catch (IOException e) {
            System.err.println("Error reading file to calculate next ID: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing last ID. Defaulting to 1.");
        }
        return 1; // Default to 1 if the file is empty or an error occurs
    }

    @FXML
    public void onCategoryMenuClick() {
        FXMLLoader fxmlLoader =
                new FXMLLoader(AddNewIngredientScreen.class.getResource("/com/example/doric7/categoryScreen.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);
            stage.setScene(scene);
            stage.setTitle("Category Screen");

            CategoryScreenController controller = fxmlLoader.getController();
            controller.setStage(stage);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    public void onAddNewCategoryClick() {
        FXMLLoader fxmlLoader =
                new FXMLLoader(AddNewIngredientScreen.class.getResource("/com/example/doric7/addNewCategoryScreen.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);
            stage.setScene(scene);
            stage.setTitle("Category Screen");

            AddNewCategoryController controller = fxmlLoader.getController();
            controller.setStage(stage);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    public void onIngredientsMenuClick() {
        FXMLLoader fxmlLoader =
                new FXMLLoader(AddNewIngredientScreen.class.getResource("/com/example/doric7/ingredientsScreen.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);
            stage.setScene(scene);
            stage.setTitle("Ingredients Screen");

            IngredientScreenController controller = fxmlLoader.getController();
            controller.setStage(stage);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    public void onAddNewIngredientClick() {
        FXMLLoader fxmlLoader =
                new FXMLLoader(AddNewIngredientScreen.class.getResource("/com/example/doric/addNewIngredientsScreen.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);
            stage.setScene(scene);
            stage.setTitle("Add new Ingredient");

            AddNewIngredientController controller = fxmlLoader.getController();
            controller.setStage(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onMealsMenuClick() {
        FXMLLoader fxmlLoader =
                new FXMLLoader(AddNewIngredientScreen.class.getResource("/com/example/doric7/mealsScreen.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);
            stage.setScene(scene);
            stage.setTitle("Meals Screen");

            MealsScreenController controller = fxmlLoader.getController();
            controller.setStage(stage);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    public void onAddNewMealClick() {
        FXMLLoader fxmlLoader =
                new FXMLLoader(AddNewIngredientScreen.class.getResource("/com/example/doric/addNewMealScreen.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);
            stage.setScene(scene);
            stage.setTitle("Add new Ingredient");

            AddNewMealController controller = fxmlLoader.getController();
            controller.setStage(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onChefMenuClick() {
        FXMLLoader fxmlLoader =
                new FXMLLoader(AddNewIngredientScreen.class.getResource("/com/example/doric7/chefsScreen.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);
            stage.setScene(scene);
            stage.setTitle("Chefs Screen");

            ChefsScreenController controller = fxmlLoader.getController();
            controller.setStage(stage);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    public void onAddNewChefClick() {
        FXMLLoader fxmlLoader =
                new FXMLLoader(AddNewIngredientScreen.class.getResource("/com/example/doric7/addNewChefScreen.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);
            stage.setScene(scene);
            stage.setTitle("Chefs Screen");

            AddNewChefController controller = fxmlLoader.getController();
            controller.setStage(stage);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    public void onWaitersMenuClick() {
        FXMLLoader fxmlLoader =
                new FXMLLoader(AddNewIngredientScreen.class.getResource("/com/example/doric7/waitersScreen.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);
            stage.setScene(scene);
            stage.setTitle("Waiters Screen");

            WaiterScreenController controller = fxmlLoader.getController();
            controller.setStage(stage);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    public void onAddNewWaiterClick() {
        FXMLLoader fxmlLoader =
                new FXMLLoader(AddNewIngredientScreen.class.getResource("/com/example/doric/addNewWaitersScreen.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);
            stage.setScene(scene);
            stage.setTitle("Add new Chef");

            AddNewWaiterController controller = fxmlLoader.getController();
            controller.setStage(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onDeliverersMenuClick() {
        FXMLLoader fxmlLoader =
                new FXMLLoader(AddNewIngredientScreen.class.getResource("/com/example/doric7/deliverersScreen.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);
            stage.setScene(scene);
            stage.setTitle("Deliverers Screen");

            DelivererScreenController controller = fxmlLoader.getController();
            controller.setStage(stage);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    public void onAddNewDelivererClick() {
        FXMLLoader fxmlLoader =
                new FXMLLoader(AddNewIngredientScreen.class.getResource("/com/example/doric/addNewDelivererScreen.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);
            stage.setScene(scene);
            stage.setTitle("Add new Deliverer");

            AddNewDelivererScreenController controller = fxmlLoader.getController();
            controller.setStage(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onRestaurantsMenuClick() {
        FXMLLoader fxmlLoader =
                new FXMLLoader(AddNewIngredientScreen.class.getResource("/com/example/doric7/restaurantsScreen.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);
            stage.setScene(scene);
            stage.setTitle("Restaurants Screen");

            RestaurantScreenController controller = fxmlLoader.getController();
            controller.setStage(stage);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    public void onAddNewRestaurantClick() {
        FXMLLoader fxmlLoader =
                new FXMLLoader(AddNewIngredientScreen.class.getResource("/com/example/doric/addNewRestaurantScreen.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);
            stage.setScene(scene);
            stage.setTitle("Add new Deliverer");

            AddNewDelivererScreenController controller = fxmlLoader.getController();
            controller.setStage(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onOrdersMenuClick() {
        FXMLLoader fxmlLoader =
                new FXMLLoader(AddNewIngredientScreen.class.getResource("/com/example/doric7/ordersScreen.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);
            stage.setScene(scene);
            stage.setTitle("Orders Screen");

            OrdersScreenController controller = fxmlLoader.getController();
            controller.setStage(stage);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    public void onAddNewOrderClick() {
        FXMLLoader fxmlLoader =
                new FXMLLoader(AddNewIngredientScreen.class.getResource("/com/example/doric/addNewOrderScreen.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);
            stage.setScene(scene);
            stage.setTitle("Add new Chef");

            AddNewOrderController controller = fxmlLoader.getController();
            controller.setStage(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onContractsMenuClick() {
        FXMLLoader fxmlLoader =
                new FXMLLoader(AddNewIngredientScreen.class.getResource("/com/example/doric7/contractsScreen.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);
            stage.setScene(scene);
            stage.setTitle("Contracts Screen");

            ContractsScreenController controller = fxmlLoader.getController();
            controller.setStage(stage);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    public void onAddNewContractsClick() {
        FXMLLoader fxmlLoader =
                new FXMLLoader(AddNewIngredientScreen.class.getResource("/com/example/doric/addNewContractsScreen.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);
            stage.setScene(scene);
            stage.setTitle("Add new Chef");

            AddNewContractController controller = fxmlLoader.getController();
            controller.setStage(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
