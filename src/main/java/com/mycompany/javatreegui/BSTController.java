package com.mycompany.javatreegui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class BSTController {

    @FXML
    private TextField textField;
    @FXML
    private Label statsText1;
    @FXML
    private BstPane bstPane;
    private BST<Integer> tree = new BST<>();

    public void setBstPane(BstPane bstPane) {
        this.bstPane = bstPane;
        if (this.bstPane != null) {
            this.bstPane.setTree(this.tree);
        } else {
            System.out.println("BstPane is null. Check FXML configuration.");
        }
    }

    @FXML
    private void goHome() throws IOException {
        App.setRoot("homePageUI", 400, 400);
    }

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

    @FXML
    private void insertValue() {
        try {
            int value = Integer.parseInt(textField.getText());
            PerformanceData data = tree.insert(value);
            statsText1.setText("Time Taken for Operation: " + data.opTime + "ns   Nodes Travelled: " + data.nodesTravelled);
            if (data.success) {
                bstPane.setTree(tree);
                bstPane.displayTree();
                //showNotification("Node Inserted", "Node " + value + " was inserted into the tree");

            } else {
                showAlert("Insertion Failed", "Node " + value + " could not be inserted (duplicate)");
            }
            textField.clear();
        } catch (Exception e) {
            showAlert("Invalid Input", "Please enter a valid integer.");
        }
    }

    @FXML
    private void deleteValue() {
        try {
            int value = Integer.parseInt(textField.getText());
            PerformanceData deletionResult = tree.delete(value);
            statsText1.setText("Time Taken for Operation: " + deletionResult.opTime + "ns   Nodes Travelled: " + deletionResult.nodesTravelled);
            if (deletionResult.success) {
                //showNotification("Node Deleted", "Node " + value + " was deleted from the tree");
                bstPane.displayTree();
            } else {
                showAlert("Node Not Found", "Node " + value + " was not found in the tree");
            }
            textField.clear();
        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Please enter a valid integer.");
        }
    }

    @FXML
    private void searchValue() {
        try {
            int value = Integer.parseInt(textField.getText());
            PerformanceData searchData = tree.search(value);
            statsText1.setText("Time Taken for Operation: " + searchData.opTime + "ns   Nodes Travelled: " + searchData.nodesTravelled);
            if (searchData.success) {
                showNotification("Node found!", "Node " + value + " is in the tree");
            } else {
                showAlert("Node not found", "Node " + value + " was not found in the tree");
            }
        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Please enter a valid integer.");
        }
    }
}
