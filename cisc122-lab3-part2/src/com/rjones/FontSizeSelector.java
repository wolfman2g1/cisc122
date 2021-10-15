package com.rjones;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class FontSizeSelector extends Application {
    public static void main(String[] args) {
        // Launch the application.
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Constants for the scene dimensions
        final double WIDTH = 300.0, HEIGHT = 200.0;
        // Create the sample text.
        Label sampleText = new Label("Sample Text");
        // Create the menu bar.
        MenuBar menuBar = new MenuBar();
        // Create the File menu.
        Menu fileMenu = new Menu("File");
        MenuItem exitItem = new MenuItem("Exit");
        fileMenu.getItems().add(exitItem);
        // Register an event handler for the exit item.
        exitItem.setOnAction(event -> {
            primaryStage.close();

        });
        /** start lab */
        Menu fontMenu = new Menu("Font Size");
        MenuItem m1 = new MenuItem("6 points");
        MenuItem m2 = new MenuItem("9 points");
        MenuItem m3 = new MenuItem("12 points");
        MenuItem m4 = new MenuItem("18 points");
        MenuItem m5 = new MenuItem("24 points");
        fontMenu.getItems().add(m1);
        fontMenu.getItems().add(m2);
        fontMenu.getItems().add(m3);
        fontMenu.getItems().add(m4);
        fontMenu.getItems().add(m5);

        // events
        m1.setOnAction(event -> {
            sampleText.setStyle("-fx-font-size: 6pt;");
        });
        m2.setOnAction(event -> {
            sampleText.setStyle("-fx-font-size: 9pt;");
        });
        m3.setOnAction(event -> {
            sampleText.setStyle("-fx-font-size: 12pt;");
        });
        m4.setOnAction(event -> {
            sampleText.setStyle("-fx-font-size: 18pt;");
        });
        m5.setOnAction(event -> {
            sampleText.setStyle("-fx-font-size: 24pt;");
        });
// Add the menu to the menu bar.
        menuBar.getMenus().addAll(fileMenu,fontMenu);
        // Create a BorderPane with the sample text in the center.
        BorderPane borderPane = new BorderPane(sampleText);
        // Add the menu bar to the top region.
        borderPane.setTop(menuBar);
        // Create a Scene and display it.
        Scene scene = new Scene(borderPane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

