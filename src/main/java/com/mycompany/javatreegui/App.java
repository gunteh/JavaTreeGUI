package com.mycompany.javatreegui;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;     

    //variables
    double buttonWidth = 220;
    double buttonHeight = 30;
    double spaceBetweenButtons = 20;  
    int stageWidth = 1000;
    int stageHeight = 800;

    public static void main(String[] args) {
        launch(args);
    }

    @SuppressWarnings("exports")
    @Override
    public void start(Stage stage) throws IOException {
        try {
            // Main layout is a BorderPane shown in a Scene
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 1000, 800);

            // Set background for visibility
            root.setStyle("-fx-background-color: lightblue;");

            // Create an AnchorPane
            AnchorPane anchorPane = new AnchorPane();
            anchorPane.setStyle("-fx-background-color: lightblue;"); // Setting anchorPane color to blue

            // Buttons
            Button avlButton = new Button("AVL Tree");
            Button bstButton = new Button("BST Tree");

            // Set preferred sizes for buttons
            avlButton.setPrefWidth(buttonWidth);
            avlButton.setPrefHeight(buttonHeight);
            bstButton.setPrefWidth(buttonWidth);
            bstButton.setPrefHeight(buttonHeight);

            // Add buttons to the screen (AnchorPane)
            anchorPane.getChildren().addAll(avlButton, bstButton);

            // Calculate center positions
            double centerX = (stageWidth - buttonWidth) / 2; // Assuming fixed window width
            double centerY = (stageHeight - (2 * buttonHeight + spaceBetweenButtons)) / 2; // Assuming fixed window height

            // Position buttons within the AnchorPane
            AnchorPane.setLeftAnchor(avlButton, centerX);
            AnchorPane.setTopAnchor(avlButton, centerY);
            AnchorPane.setLeftAnchor(bstButton, centerX);
            AnchorPane.setTopAnchor(bstButton, centerY + buttonHeight + spaceBetweenButtons);

            // Add AnchorPane to the center of the BorderPane
            root.setCenter(anchorPane);

            // Stage settings
            stage.setScene(scene);
            stage.setTitle("Tree Data Structure Visualization");
            stage.setWidth(stageWidth);
            stage.setHeight(stageHeight);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}