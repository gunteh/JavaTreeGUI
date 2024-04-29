package com.mycompany.javatreegui;
public interface Tree<E> extends Iterable<E> {
    public PerformanceData insert(E e);
    public PerformanceData delete(E e);
    public PerformanceData search(E e);
    public void inorder();
    public void postorder();
    public void preorder();
    public int getSize();
    public boolean isEmpty();
    
}
