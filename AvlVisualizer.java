/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gunterherd
 */
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
//import JavaTreeGUI.src.main.java.BstVisualizer;
import src.main.java.AVLTree;

import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class AvlVisualizer extends BstVisualizer {
    private static AVLTree<Integer> tree;
    private static AvlPane view;

    @Override
    public void start(Stage primaryStage){
        tree = new AVL<>();
        BorderPane pane = new BorderPane();
        view = new AvlPane(tree);
        setPane(pane, view, tree);
        setStage(pane, primaryStage, "AVL Visualisation");
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"This is a AVL Visualiser for the operations of insertion and deletion.\n\n" +
                "Use Insert to add a new node, use delete to remove a node.", ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
    }
}
