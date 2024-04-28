package com.mycompany.javatreegui;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gunterherd
 */

import java.util.ArrayList;

public class AVL<E extends Comparable<E>> extends BST<E> {
    public AVL() {
    }

    public AVL(E[] objects) {
        super(objects);
    }

    @Override
    public TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    public PerformanceData insert(E e) {
        PerformanceData data = super.insert(e);
        data.rotations = balancePath(e);
        return data;
    }

    private void updateHeight(TreeNode<E> node) {
        if (node.left == null && node.right == null)
            node.height = 0;
        else if (node.left == null)
            node.height = 1 + node.right.height;
        else if (node.right == null)
            node.height = 1 + node.left.height;
        else
            node.height = 1 + Math.max(node.left.height, node.right.height);
    }

    private int balancePath(E e){
        ArrayList<TreeNode<E>> path = path(e);
        for (int i = path.size() - 1; i >= 0; i--) {
            TreeNode<E> A = path.get(i);
            updateHeight(A);
            TreeNode<E> parentOfA = A == root ? null : path.get(i - 1);

            switch (balanceFactor(A)) {
                case -2:
                    if(balanceFactor(A.left) <= 0) {
                        balanceLL(A, parentOfA);
                        return 1;
                    } else {
                        balanceLR(A, parentOfA);
                        return 2;
                    }
                case 2:
                    if(balanceFactor(A.right) >= 0) {
                        balanceRR(A, parentOfA);
                        return 1;
                    } else {
                        balanceRL(A, parentOfA);
                        return 2;
                    }
            }
        }
        return 0;
    }

    private int balanceFactor(TreeNode<E> node) {
        if (node.right == null)
            return -node.height;
        else if (node.left == null)
            return node.height;
        else
            return node.right.height - node.left.height;
    }

    private void balanceLL(TreeNode<E> A, TreeNode<E> parentOfA) {
        TreeNode<E> B = A.left;
        if (A == root)
            root = B;
        else {
            if (parentOfA.left == A)
                parentOfA.left = B;
            else
                parentOfA.right = B;
        }
        A.left = B.right;
        B.right = A;
        updateHeight(A);
        updateHeight(B);
    }

    private void balanceRR(TreeNode<E> A, TreeNode<E> parentOfA) {
        TreeNode<E> B = A.right;
        if (A == root)
            root = B;
        else {
            if (parentOfA.left == A)
                parentOfA.left = B;
            else
                parentOfA.right = B;
        }
        A.right = B.left;
        B.left = A;
        updateHeight(A);
        updateHeight(B);
    }

    private void balanceLR(TreeNode<E> A, TreeNode<E> parentOfA) {
        TreeNode<E> B = A.left;
        TreeNode<E> C = B.right;
        if (A == root)
            root = C;
        else {
            if (parentOfA.left == A)
                parentOfA.left = C;
            else
                parentOfA.right = C;
        }
        B.right = C.left;
        A.left = C.right;
        C.left = B;
        C.right = A;
        updateHeight(A);
        updateHeight(B);
        updateHeight(C);
    }

    private void balanceRL(TreeNode<E> A, TreeNode<E> parentOfA) {
        TreeNode<E> B = A.right;
        TreeNode<E> C = B.left;
        if (A == root)
            root = C;
        else {
            if (parentOfA.left == A)
                parentOfA.left = C;
            else
                parentOfA.right = C;
        }
        B.left = C.right;
        A.right = C.left;
        C.left = A;
        C.right = B;
        updateHeight(A);
        updateHeight(B);
        updateHeight(C);
    }

    @Override
    public PerformanceData delete(E element){
        PerformanceData data;
        if(root == null) {
            data = new PerformanceData(getSize(), 0);
            data.updateTime();
            return data;
        } else {data = new PerformanceData(getSize(), root.height);}

        data.nodesTravelled++;
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while(current != null){
            data.nodesTravelled++;
            if(element.compareTo(current.element) < 0){
                parent = current;
                current = current.left;
            } else if (element.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else
                break;
        }
        if(current == null) {
            data.updateTime();
            return data;
        }
        if(current.left == null){
            if(parent == null)
                root = current.right;
            else {
                if (element.compareTo(parent.element) < 0)
                    parent.left = current.right;
                else
                    parent.right = current.right;
                data.rotations = balancePath(parent.element);
            }
        } else {
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }

            current.element = rightMost.element;

            if (parentOfRightMost.right == rightMost)
                parentOfRightMost.right = rightMost.left;
            else
                parentOfRightMost.left = rightMost.left;
            data.rotations = balancePath(parentOfRightMost.element);
        }
        data.success = true;
        size--;
        data.updateTime();
        return data;
    }
}
