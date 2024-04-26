package com.mycompany.javatreegui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class BSTController {
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

    //Implement
    @FXML
    private void insertValue(){

    }
    @FXML
    private void deleteValue(){

    }
    @FXML
    private void searchValue(){

    }
}