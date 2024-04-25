/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.BstPane to edit this template
 */


/**
 *
 * @author gunterherd
 */

//import JavaTreeGUI.src.main.java.TreeNode;
import src.main.java.Trees.BinarySearchTree;

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
    private BinarySearchTree<Integer> tree;
    private double radius = 15;
    private double verticalGap = 50;

    protected BstPane(){ }

    BstPane(BinarySearchTree<Integer> tree){
        this.tree = tree;
        setStatus("Tree is empty"); //default tree will be empty
        setBackground(new Background(new BackgroundFill(Color.web("#" + "40E0D0"), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public void setStatus(String msg){
        getChildren().add(new Text(20, 20, msg));
    }

     public void displayTree(){
        this.getChildren().clear();
        if(tree.getRoot() != null){
            displayTree(tree.getRoot(), getWidth() / 2, verticalGap, getWidth() / 4, Color.MEDIUMPURPLE);
        }
    }

    protected void displayTree(TreeNode<Integer> root, double x, double y, double hGap, Color color){
        if(root.left != null){
            getChildren().add(new Line(x - hGap, y + verticalGap, x, y));
            displayTree(root.left, x - hGap, y + verticalGap, hGap / 2,color);
        }

        if (root.right != null){
            getChildren().add(new Line(x + hGap, y + vGap, x, y));
            displayTree(root.right, x + hGap, y + verticalGap, hGap / 2, color);
        }

        Circle circle = new Circle(x, y, radius);
        circle.setFill(color);
        circle.setStroke(Color.BLACK);
        getChildren().addAll(circle, new Text(x - 4, y + 4, root.element + ""));
    }

}
