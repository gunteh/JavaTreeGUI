package com.mycompany.javatreegui;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.BstPane to edit this template
 */


/**
 *
 * @author gunterherd
 */

//import JavaTreeGUI.src.main.java.TreeNode;
//import JavaTreeGUI.src.main.java.BST;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class BstPane extends Pane {
    private BST<Integer> treeNode;
    private double radius = 15;
    private double vGap = 50;

    public BstPane(){
        this.treeNode = new AVL<Integer>();
        setStatus("Tree is empty");
        setBackground(new Background(new BackgroundFill(Color.web("#" + "fefae0"), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public void setStatus(String msg){
        getChildren().add(new Text(20, 20, msg));
    }

    public void setTree(BST<Integer> tree) {
        this.treeNode = tree;
        System.out.println("Set tree instance: " + tree.getRoot());
        displayTree(); // Update tree display when a new tree is set
    }

    public void displayTree() {
        getChildren().clear();
        System.out.println("Root Node: " + treeNode.getRoot());
        if (treeNode.getRoot() != null) {                //Trying to get root node but it always is coming up as null which is the reason display isn't working
            displayTree(treeNode.getRoot(), getWidth() / 2, vGap, getWidth() / 4);
        }
    }

    private void displayTree(TreeNode<Integer> root, double x, double y, double hGap) {
        if (root.left != null) {
            // Draw line to left node
            getChildren().add(new Line(x - hGap, y + vGap, x, y));
            // Draw left subtree
            displayTree(root.left, x - hGap, y + vGap, hGap / 2);
        }

        if (root.right != null) {
            // Draw line to right node
            getChildren().add(new Line(x + hGap, y + vGap, x, y));
            // Draw right subtree
            displayTree(root.right, x + hGap, y + vGap, hGap / 2);
        }

        // Draw the node
        Circle circle = new Circle(x, y, 15);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        getChildren().addAll(circle, new Text(x - 4, y + 4, root.element.toString()));
    }

}
