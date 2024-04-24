public class Node<T extends Comparable<T>> {
    T data;
    int height;
    Node<T> left;
    Node<T> right;

    public Node(T data){
        this.data = data;
        this.height = 1;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
