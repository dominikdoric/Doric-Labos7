module com.example.doric7 {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.doric7 to javafx.fxml;
    exports com.example.doric7.screens.firstScreen;
    opens com.example.doric7.screens.firstScreen to javafx.fxml;
    exports com.example.doric7.screens.categoryScreen;
    opens com.example.doric7.screens.categoryScreen to javafx.fxml;
    exports com.example.doric7.screens.chefsScreen;
    opens com.example.doric7.screens.chefsScreen to javafx.fxml;
    exports com.example.doric7.screens.contractsScreen;
    opens com.example.doric7.screens.contractsScreen to javafx.fxml;
    exports com.example.doric7.screens.deliverersScreen;
    opens com.example.doric7.screens.deliverersScreen to javafx.fxml;
    exports com.example.doric7.screens.ingredientsScreen;
    opens com.example.doric7.screens.ingredientsScreen to javafx.fxml;
    exports com.example.doric7.screens.mealsScreen;
    opens com.example.doric7.screens.mealsScreen to javafx.fxml;
    exports com.example.doric7.screens.ordersScreen;
    opens com.example.doric7.screens.ordersScreen to javafx.fxml;
    exports com.example.doric7.screens.restaurantsScreen;
    opens com.example.doric7.screens.restaurantsScreen to javafx.fxml;
    exports com.example.doric7.screens.waitersScreen;
    opens com.example.doric7.screens.waitersScreen to javafx.fxml;
}