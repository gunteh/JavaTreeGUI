package com.mycompany.javatreegui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class HomePageController {

    @FXML
    private void goToBST() throws IOException {
        App.setRoot("binaryTreeUI", 1000, 800);
    }
    @FXML
    private void goToAVL() throws IOException {
        App.setRoot("avlTreeUI", 1000, 800);
    }

    public void handleMouseEntered(MouseEvent event) {
        Button button = (Button) event.getSource();
        button.setStyle("-fx-background-color: #bc6c25; -fx-font-weight: bold;");
    }

    public void handleMouseExited(MouseEvent event) {
        Button button = (Button) event.getSource();
        button.setStyle("-fx-background-color: #dda15e; -fx-font-weight: bold;");
    }
}
