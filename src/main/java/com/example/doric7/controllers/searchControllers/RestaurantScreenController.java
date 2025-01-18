package com.example.doric7.controllers.searchControllers;

import com.example.doric7.app.screens.searchScreens.RestaurantScreen;
import com.example.doric7.controllers.addNewItemControllers.*;
import com.example.doric7.models.*;
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
import java.util.List;
import java.util.stream.Collectors;

import static com.example.doric7.app.Main.*;

public class RestaurantScreenController {
    @FXML
    private TableView<Restaurant> restaurantTableView;
    @FXML
    private TextField restaurantName;
    @FXML
    private TableColumn<Restaurant, String> nameColumn;
    @FXML
    private TableColumn<Restaurant, String> addressColumn;
    @FXML
    private TableColumn<Restaurant, String> mealsColumn;
    @FXML
    private TableColumn<Restaurant, String> chefsColumn;
    @FXML
    private TableColumn<Restaurant, String> waitersColumn;
    @FXML
    private TableColumn<Restaurant, String> deliverersColumn;

    private FilteredList<Restaurant> filteredRestaurant;
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        addressColumn.setCellValueFactory(data ->
                new SimpleObjectProperty<>(
                        data.getValue().getAddress().getStreet() + " "
                                + data.getValue().getAddress().getHouseNumber())
        );
        mealsColumn.setCellValueFactory(data ->
                new SimpleObjectProperty<>(
                        data.getValue().getMeals().stream()
                                .map(Meal::getName)
                                .collect(Collectors.joining(", "))
                )
        );
        chefsColumn.setCellValueFactory(data ->
                new SimpleObjectProperty<>(
                        data.getValue().getChefs().stream()
                                .map(chef -> chef.getFirstName() + " " + chef.getLastName())
                                .collect(Collectors.joining(", "))
                )
        );
        waitersColumn.setCellValueFactory(data ->
                new SimpleObjectProperty<>(
                        data.getValue().getWaiters().stream()
                                .map(waiter -> waiter.getFirstName() + " " + waiter.getLastName())
                                .collect(Collectors.joining(", "))
                )
        );
        deliverersColumn.setCellValueFactory(data ->
                new SimpleObjectProperty<>(
                        data.getValue().getDeliverers().stream()
                                .map(deliverer -> deliverer.getFirstName() + " " + deliverer.getLastName())
                                .collect(Collectors.joining(", "))
                )
        );

        List<Contract> contracts = getContractsFromFile();
        List<Bonus> bonuses = getBonusesFromFile();
        List<Address> addresses = getAddressesFromFile();
        List<Category> categories = getCategoriesFromFile();
        List<Ingredient> ingredients = getIngredientsFromFile(categories);
        List<Meal> meals = getMealsFromFile(categories, ingredients);
        List<Chef> chefs = getChefsFromFile(contracts, bonuses);
        List<Waiter> waiters = getWaitersFromFile(contracts, bonuses);
        List<Deliverer> deliverers = getDeliverersFromFile(contracts, bonuses);
        List<Restaurant> restaurants = getRestaurantsFromFile(addresses, meals, chefs, waiters, deliverers);
        filteredRestaurant = new FilteredList<>(FXCollections.observableArrayList(restaurants), s -> true);
        restaurantTableView.getItems().setAll(restaurants);
    }

    @FXML
    private void onSearchButtonClick() {
        String searchQuery = restaurantName.getText().toLowerCase();
        filteredRestaurant.setPredicate(restaurant ->
            restaurant.getName().toLowerCase().contains(searchQuery)
        );

        restaurantTableView.getItems().setAll(filteredRestaurant);
    }

    @FXML
    public void onCategoryMenuClick() {
        FXMLLoader fxmlLoader =
                new FXMLLoader(RestaurantScreen.class.getResource("/com/example/doric7/categoryScreen.fxml"));

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
                new FXMLLoader(RestaurantScreen.class.getResource("/com/example/doric7/addNewCategoryScreen.fxml"));

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
                new FXMLLoader(RestaurantScreen.class.getResource("/com/example/doric7/ingredientsScreen.fxml"));

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
                new FXMLLoader(RestaurantScreen.class.getResource("/com/example/doric/addNewIngredientsScreen.fxml"));

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
                new FXMLLoader(RestaurantScreen.class.getResource("/com/example/doric7/mealsScreen.fxml"));

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
                new FXMLLoader(RestaurantScreen.class.getResource("/com/example/doric/addNewMealScreen.fxml"));

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
                new FXMLLoader(RestaurantScreen.class.getResource("/com/example/doric7/chefsScreen.fxml"));

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
                new FXMLLoader(RestaurantScreen.class.getResource("/com/example/doric/addNewChefScreen.fxml"));

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
                new FXMLLoader(RestaurantScreen.class.getResource("/com/example/doric7/waitersScreen.fxml"));

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
                new FXMLLoader(RestaurantScreen.class.getResource("/com/example/doric/addNewWaitersScreen.fxml"));

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
                new FXMLLoader(RestaurantScreen.class.getResource("/com/example/doric7/deliverersScreen.fxml"));

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
                new FXMLLoader(RestaurantScreen.class.getResource("/com/example/doric/addNewDelivererScreen.fxml"));

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
                new FXMLLoader(RestaurantScreen.class.getResource("/com/example/doric7/restaurantsScreen.fxml"));

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
                new FXMLLoader(RestaurantScreen.class.getResource("/com/example/doric/addNewRestaurantScreen.fxml"));

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
                new FXMLLoader(RestaurantScreen.class.getResource("/com/example/doric7/ordersScreen.fxml"));

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
                new FXMLLoader(RestaurantScreen.class.getResource("/com/example/doric/addNewOrderScreen.fxml"));

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
                new FXMLLoader(RestaurantScreen.class.getResource("/com/example/doric7/contractsScreen.fxml"));

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
                new FXMLLoader(RestaurantScreen.class.getResource("/com/example/doric/addNewContractsScreen.fxml"));

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
