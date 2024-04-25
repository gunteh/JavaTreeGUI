package com.mycompany.javatreegui;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gunterherd
 */

//package trees;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
     public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXML/View.fxml"));
            primaryStage.setTitle("Trees");
            primaryStage.setScene(new Scene(root));
        }
        catch (NullPointerException e){
            e.getMessage();
        }
        primaryStage.getIcons().add(new Image("file:data/icon.jpg"));
        primaryStage.show();
        // alert.getDialogPane().setMinHeight(80);
        // alert.show();
    }
}
