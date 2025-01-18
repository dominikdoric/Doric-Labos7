package com.example.doric7.controllers.searchControllers;

import com.example.doric7.app.screens.searchScreens.CategoryScreen;
import com.example.doric7.app.screens.searchScreens.MealsScreen;
import com.example.doric7.controllers.addNewItemControllers.*;
import com.example.doric7.models.Category;
import com.example.doric7.models.Ingredient;
import com.example.doric7.models.Meal;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.doric7.app.Main.*;

public class MealsScreenController {
    @FXML
    private TableView<Meal> mealTableView;
    @FXML
    private TextField mealsName;
    @FXML
    private TableColumn<Meal, String> nameColumn;
    @FXML
    private TableColumn<Meal, String> categoryColumn;
    @FXML
    private TableColumn<Meal, String> ingredientsColumn;
    @FXML
    private TableColumn<Meal, BigDecimal> priceColumn;

    private FilteredList<Meal> filteredMeals;
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        categoryColumn.setCellValueFactory(data ->
                new SimpleObjectProperty<>(data.getValue().getCategory().getName())
        );
        ingredientsColumn.setCellValueFactory(data ->
                new SimpleObjectProperty<>(
                        data.getValue().getIngredients().stream()
                                .map(Ingredient::getName)
                                .collect(Collectors.joining(", "))
                )
        );

        List<Category> categories = getCategoriesFromFile();
        List<Ingredient> ingredients = getIngredientsFromFile(categories);
        List<Meal> meals = getMealsFromFile(categories, ingredients);
        filteredMeals = new FilteredList<>(FXCollections.observableArrayList(meals), s -> true);
        mealTableView.getItems().setAll(meals);
    }

    @FXML
    private void onSearchButtonClick() {
        String searchQuery = mealsName.getText().toLowerCase();
        filteredMeals.setPredicate(meals ->
                meals.getName().toLowerCase().contains(searchQuery)
        );

        mealTableView.getItems().setAll(filteredMeals);
    }

    @FXML
    public void onCategoryMenuClick() {
        FXMLLoader fxmlLoader =
                new FXMLLoader(MealsScreen.class.getResource("/com/example/doric7/categoryScreen.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);
            stage.setScene(scene);
            stage.setTitle("Category Search Screen");

            CategoryScreenController controller = fxmlLoader.getController();
            controller.setStage(stage);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    public void onAddNewCategoryClick() {
        FXMLLoader fxmlLoader =
                new FXMLLoader(CategoryScreen.class.getResource("/com/example/doric7/addNewCategoryScreen.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load(), 800,800);
            stage.setScene(scene);
            stage.setTitle("Add new category");

            AddNewCategoryController controller = fxmlLoader.getController();
            controller.setStage(stage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void onIngredientsMenuClick() {
        FXMLLoader fxmlLoader =
                new FXMLLoader(MealsScreen.class.getResource("/com/example/doric7/ingredientsScreen.fxml"));

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
                new FXMLLoader(CategoryScreen.class.getResource("/com/example/doric/addNewIngredientsScreen.fxml"));

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
                new FXMLLoader(MealsScreen.class.getResource("/com/example/doric7/mealsScreen.fxml"));

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
                new FXMLLoader(CategoryScreen.class.getResource("/com/example/doric/addNewMealScreen.fxml"));

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
                new FXMLLoader(MealsScreen.class.getResource("/com/example/doric7/chefsScreen.fxml"));

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
                new FXMLLoader(CategoryScreen.class.getResource("/com/example/doric/addNewChefScreen.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);
            stage.setScene(scene);
            stage.setTitle("Add new Chef");

            AddNewChefController controller = fxmlLoader.getController();
            controller.setStage(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onWaitersMenuClick() {
        FXMLLoader fxmlLoader =
                new FXMLLoader(MealsScreen.class.getResource("/com/example/doric7/waitersScreen.fxml"));

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
                new FXMLLoader(CategoryScreen.class.getResource("/com/example/doric/addNewWaitersScreen.fxml"));

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
                new FXMLLoader(MealsScreen.class.getResource("/com/example/doric7/deliverersScreen.fxml"));

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
                new FXMLLoader(CategoryScreen.class.getResource("/com/example/doric/addNewDelivererScreen.fxml"));

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
                new FXMLLoader(MealsScreen.class.getResource("/com/example/doric7/restaurantsScreen.fxml"));

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
                new FXMLLoader(CategoryScreen.class.getResource("/com/example/doric/addNewRestaurantScreen.fxml"));

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
                new FXMLLoader(MealsScreen.class.getResource("/com/example/doric7/ordersScreen.fxml"));

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
                new FXMLLoader(CategoryScreen.class.getResource("/com/example/doric/addNewOrderScreen.fxml"));

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
                new FXMLLoader(MealsScreen.class.getResource("/com/example/doric7/contractsScreen.fxml"));

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
                new FXMLLoader(CategoryScreen.class.getResource("/com/example/doric/addNewContractsScreen.fxml"));

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
