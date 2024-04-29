package com.mycompany.javatreegui;
public class TreeNode<E extends Comparable<E>> {
    public E element;
    public TreeNode<E> left;
    public TreeNode<E> right;
    public int height = 0;
    private boolean red = true;

    public TreeNode(E e){
        element = e;
    }

    public int getChildren() {
        int children = 0;
        if (left != null) children++;
        if (right != null) children++;
        return children;
    }

}
