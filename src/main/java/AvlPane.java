/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gunterherd
 */

import JavaTreeGUI.src.main.java.BstPane;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import JavaTreeGUI.src.main.java.AVL;

public class AvlPane extends BstPane {
    private AVL<Integer> tree;
    private double vGap = 50;

    AvlPane(AVL<Integer> tree){
        this.tree = tree;
        setStatus("Tree is empty");
        setBackground(new Background(new BackgroundFill(Color.web("#" + "9ACD32"), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    @Override
    public void setStatus(String msg){
        getChildren().add(new Text(20, 20, msg));
    }

    @Override
    public void displayTree(){
        this.getChildren().clear();
        if(tree.getRoot() != null){
            displayTree(tree.getRoot(), getWidth() / 2, vGap, getWidth() / 4, Color.SEAGREEN);
        }
    }
}
