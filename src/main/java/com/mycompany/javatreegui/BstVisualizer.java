package com.mycompany.javatreegui;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.BstVisualizer to edit this template
 */

/**
 *
 * @author gunterherd
 */

//import JavaTreeGUI.src.main.java.BST;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BstVisualizer extends Application {
    private static ArrayList<Integer> nodes = new ArrayList<>();

    private static BST<Integer> tree;
    private static BstPane view;

    @Override
    public void start(Stage primaryStage) {
        tree = new BST<>();
        BorderPane pane = new BorderPane();
        view = new BstPane();
        //view.setTree();
        setPane(pane, view, tree);
        setStage(pane, primaryStage, "Binary Search Tree Visualization");
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "This is a BST Visualization\n\n" +
                "Use insert to add a node, use delete to remove a node.", ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
    }

    public void setStage(BorderPane pane, Stage primaryStage, String title) {
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle(title);
        // primaryStage.getIcons().add(new Image("file:data/tree.png"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setPane(BorderPane pane, BstPane view, BST<Integer> tree) {
        pane.setCenter(view);
        TextField textField = new TextField();
        textField.setPrefColumnCount(3);
        textField.setAlignment(Pos.BASELINE_RIGHT);
        Button insert = new Button("Insert");
        Button delete = new Button("Delete");
        addFunctionalities(textField, insert, delete, tree, view);
        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(new Label("Enter a value here"), textField, insert, delete);
        hBox.setAlignment(Pos.BASELINE_CENTER);
        pane.setBottom(hBox);
    }

    public void addFunctionalities(TextField textField, Button insert, Button delete, BST<Integer> tree, BstPane view) {
        insert.setOnAction(e -> {
            if (textField.getText().length() == 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Nothing entered", ButtonType.OK);
                alert.getDialogPane().setMinHeight(80);
                alert.show();
            } else {
                int key = Integer.parseInt(textField.getText());
                nodes.add(key);
                if (tree.search(key).success) {
                    view.displayTree();
                    view.setStatus(key + " is present already");
                } else {
                    tree.insert(key);
                    view.displayTree();
                    view.setStatus(key + " is inserted");
                }
                textField.clear();
            }
        });

        delete.setOnAction(e -> {
            int key = Integer.parseInt(textField.getText());
            if (!tree.search(key).success) {
                view.displayTree();
                view.setStatus(key + " is not present");
            } else {
                tree.delete(key);
                view.displayTree();
                view.setStatus(key + " is replaced and is deleted");
            }
            textField.clear();
        });
    }
}
