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

    opens com.example.doric7.app to javafx.fxml;
    exports com.example.doric7.app.screens;
    opens com.example.doric7.app.screens to javafx.fxml;
    exports com.example.doric7.controllers;
    opens com.example.doric7.controllers to javafx.fxml;
    exports com.example.doric7.app;
    opens com.example.doric7.models to javafx.base;
    exports com.example.doric7.models;
}