package com.mycompany.javatreegui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AVLController {

    //FXML variables/objects with ID
    @FXML
    private Label statsText1;
    @FXML
    private Label statsText2;
    @FXML
    private TextField textField;
    @FXML
    private AvlPane avlPane;
    private AVL<Integer> tree = new AVL<>();
    
    public void setAvlPane(AvlPane avlPane) {
        this.avlPane = avlPane;
        if (this.avlPane != null) {
            this.avlPane.setTree(this.tree);
        } else {
            System.out.println("AvlPane is null. Check FXML configuration.");
        }
    }

    @FXML
    private void goHome() throws IOException {
        App.setRoot("homePageUI", 400, 400);
    }   
    
    //Change button color based on Mouse position
    public void handleMouseEntered(MouseEvent event) {
        Button button = (Button) event.getSource();
        button.setStyle("-fx-background-color: #bc6c25; -fx-font-weight: bold;");
    }

    public void handleMouseExited(MouseEvent event) {
        Button button = (Button) event.getSource();
        button.setStyle("-fx-background-color: #dda15e; -fx-font-weight: bold;");
    }

    private void showAlert(String title, String message) {  
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    private void showNotification(String title, String message) {  
        Alert popup = new Alert(AlertType.INFORMATION);
        popup.setTitle(title);
        popup.setHeaderText(null);
        popup.setContentText(message);
        popup.showAndWait();
    }

    //Inserts Value into the tree
    @FXML
    private void insertValue() {
        try {
            int value = Integer.parseInt(textField.getText());
            //gather and show data regarding insertion of node
            PerformanceData insertdata = tree.insert(value);
            statsText1.setText("Tree Height: " + tree.root.height + "   Rotations Required: " + insertdata.rotations);
            statsText2.setText("Time Taken for Operation: " + insertdata.opTime + "ns   Nodes Travelled: " + insertdata.nodesTravelled);
            if (insertdata.success) {
                //Display updated tree
                avlPane.setTree(tree);
                avlPane.displayTree();       
                //showNotification("Node Inserted", "Node " + value + " was inserted into the tree");
            } else {
                showAlert("Insertion Failed", "Node " + value + " could not be inserted (duplicate)");
            }
            textField.clear();
        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Please enter a valid integer.");
        }
    }

    //Deletes value from the tree
    @FXML
    private void deleteValue() {
        try {
            int value = Integer.parseInt(textField.getText());
            PerformanceData deleteData = tree.delete(value);
            statsText1.setText("Tree Height: " + tree.root.height + "   Rotations Required: " + deleteData.rotations);
            statsText2.setText("Time Taken for Operation: " + deleteData.opTime + "ns   Nodes Travelled: " + deleteData.nodesTravelled);
            if (deleteData.success) {
                //Displays updated tree
                avlPane.setTree(tree);
                avlPane.displayTree();                         
                //showNotification("Node Deleted", "Node " + value + " was deleted from the tree");
            } else {
                showAlert("Node Not Found", "Node " + value + " was not found in the tree");
            }
            textField.clear();
        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Please enter a valid integer.");
        }
    }

    @FXML
    private void searchValue(){
        try {
            int value = Integer.parseInt(textField.getText());
            PerformanceData searchData = tree.search(value);
            statsText1.setText("Tree Height: " + tree.root.height + "   Rotations Required: " + searchData.rotations);
            statsText2.setText("Time Taken for Operation: " + searchData.opTime + "ns   Nodes Travelled: " + searchData.nodesTravelled);
            if(searchData.success) {
            showNotification("Node found!", "Node " + value + " is in the tree");
            }else {
            showAlert("Node not found", "Node " + value + " was not found in the tree");
            }
                } catch (NumberFormatException e) {
                   showAlert("Invalid Input", "Please enter a valid integer.");
                }
    }
}