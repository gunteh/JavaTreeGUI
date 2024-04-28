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
    private BST<Integer> tree;
    private double vGap = 50;

    public BstPane() {
        this.tree = new BST<Integer>();
        setStatus("Empty Tree");
        setBackground(new Background(new BackgroundFill(Color.web("#" + "fefae0"), CornerRadii.EMPTY, Insets.EMPTY)));

    }

    public void setStatus(String msg) {
        getChildren().add(new Text(20, 20, msg));
    }

    public void setTree(BST<Integer> tree) {
        this.tree = tree;
        System.out.println("Set tree instance: " + tree.getRoot().element);
        displayTree(); // Update tree display when a new tree is set
    }

    public void displayTree() {
        getChildren().clear();
        System.out.println("Root Node: " + tree.getRoot().element);
        if (tree.getRoot() != null) {
            displayTree(tree.getRoot(), getWidth() / 2, vGap, getWidth() / 4);
        }
    }

    protected void displayTree(TreeNode<Integer> root, double x, double y, double hGap) {
        if (root.left != null) {
            getChildren().add(new Line(x - hGap, y + vGap, x, y));
            displayTree(root.left, x - hGap, y + vGap, hGap / 2);
        }

        if (root.right != null) {
            getChildren().add(new Line(x + hGap, y + vGap, x, y));
            displayTree(root.right, x + hGap, y + vGap, hGap / 2);
        }
        Circle circle = new Circle(x, y, 15);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        getChildren().addAll(circle, new Text(x - 4, y + 4, root.element.toString() + ""));
    }

}
