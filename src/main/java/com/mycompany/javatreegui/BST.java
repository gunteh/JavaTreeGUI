package com.mycompany.javatreegui;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gunterherd
 */

//import JavaTreeGUI.src.main.java.Tree;
//import JavaTreeGUI.src.main.java.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;

public class BST<E extends Comparable<E>> implements Tree<E>  {
    public TreeNode<E> root;
    public int size = 0;

    public BST() {
    }

    public BST(E[] objects) {
        for (E o: objects)
            insert(o);
    }

    public int height(TreeNode<E> N) {
        if (N == null)
            return 0;
        return N.height;
    }

    @Override
    public PerformanceData search(E e) {
        PerformanceData data = new PerformanceData(getSize(), root.height);
        if (root == null) {
            data.updateTime();
            return data;
        }
        TreeNode<E> curNode = root;
        data.nodesTravelled++;
        while(true) {
            if (curNode == null) break;
            else if (e.compareTo(root.element) == 0) {
                data.success = true;
                break;
            } else {
                data.nodesTravelled++;
                if (e.compareTo(root.element) > 0) curNode = curNode.right;
                else curNode = curNode.left;
            }
        }
        data.updateTime();
        return data;
    }

    @Override
    public PerformanceData insert(E e) {
        PerformanceData data;
        if (root == null) {
            data = new PerformanceData(getSize(), 0);
            data.success = true;
            size++;
            data.updateTime();
            return data;
        } else {data = new PerformanceData(getSize(), root.height);}
        TreeNode<E> curNode = root;
        data.nodesTravelled++;
        while (true) {
            if (e.compareTo(curNode.element) < 0) {
                if (curNode.left == null) {curNode.left = createNewNode(e); data.success = true; size++; break;}
                else {curNode = curNode.left; data.nodesTravelled++;}
            } else if (e.compareTo(curNode.element) > 0) {
                if (curNode.right == null) {curNode.right = createNewNode(e); data.success = true; size++; break;}
                else {curNode = curNode.right; data.nodesTravelled++;}
            } else {break;}
        }
        data.updateTime();
        return data;
    }

    public TreeNode<E> createNewNode(E e){
        return new TreeNode<>(e);
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    private void inorder(TreeNode<E> root){
        if(root != null){
            inorder(root.left);
            System.out.print(root.element+" ");
            inorder(root.right);
        }
    }

    private void preorder(TreeNode<E> root){
        if(root != null){
            System.out.print(root.element+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    public TreeNode<E> getRoot(){
        return root;
    }

    private void postorder(TreeNode<E> root){
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.element +" ");
        }
    }

    @Override
    public void postorder() {
        postorder(root);
    }

    @Override
    public void preorder() {
        preorder(root);
    }

    public ArrayList<TreeNode<E>> path(E e){
        ArrayList<TreeNode<E>> list = new ArrayList<>();
        TreeNode<E> current = root;
        while(current != null){
            list.add(current);
            if(e.compareTo(current.element) < 0)
                current = current.left;
            else if(e.compareTo(current.element) > 0)
                current = current.right;
            else
                break;
        }
        return list;
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    private E findMax(TreeNode<E> root){
        TreeNode<E> temp = root;
        while(temp.right != null)
            temp = temp.right;
        return temp.element;
    }

    @Override
    public PerformanceData delete(E e) {
        if (root == null)
            return null;

        PerformanceData data = new PerformanceData(getSize(), root.height);
        data.nodesTravelled++;
        boolean isLeft = true;
        TreeNode<E> curNode = root;
        TreeNode<E> parent = null;
        while (curNode != null && e.compareTo(curNode.element) != 0) {
            data.nodesTravelled++;
            parent = curNode;
            if (e.compareTo(curNode.element) < 0) {
                isLeft = true;
                curNode = curNode.left;
            } else {
                isLeft = false;
                curNode = curNode.right;
            }
        }
        if (curNode == null) {
            return null;
        }
        if (curNode.getChildren() == 0) {
            if (isLeft) parent.left = null;
            else parent.right = null;
            data.updateTime();
            return data;
        } else {
            TreeNode<E> replacement;
            if (curNode.getChildren() == 2) {
                replacement = findSuccessor(curNode);
                delete(replacement.element);
                replacement.left = curNode.left;
                replacement.right = curNode.right;
            } else {
                if (curNode.left != null) {
                    replacement = curNode.left;
                } else {
                    replacement = curNode.right;
                }
            }
            if (parent == null) {
                root = replacement;
            } else if (isLeft) {
                parent.left = replacement;
            } else {
                parent.right = replacement;
            }
        }
        size--;
        data.success = true;
        data.updateTime();
        return data;
    }

    TreeNode<E> findSuccessor(TreeNode<E> root) {
        TreeNode<E> curNode = root.right;
        if (curNode == null) {return root;}
        while (curNode.left != null) {curNode = curNode.left;}
        return curNode;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
