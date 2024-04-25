package com.mycompany.javatreegui;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
//import JavaTreeGUI.src.main.java.BstVisualizer; 
//import JavaTreeGUI.src.main.java.AvlVisualiser; 

public class View {
    @FXML
    private Button avl;
    @FXML
    private Button bst;

    @FXML
    private void bstAction(){
        bst.setOnAction(e-> setStage(new BstVisualizer()));
    }
    
    @FXML
    private void avlAction(){
        avl.setOnAction(e-> setStage(new AvlVisualizer()));
    }


    private void setStage(BstVisualizer menu){
        Stage menuStage = new Stage();
        menu.start(menuStage);
        menuStage.show();
    }
}
