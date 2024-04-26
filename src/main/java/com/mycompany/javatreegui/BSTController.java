package com.mycompany.javatreegui;

import java.io.IOException;
import javafx.fxml.FXML;

public class BSTController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary", 400, 400);
    }
}