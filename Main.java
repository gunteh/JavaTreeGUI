public class Main {
    public static void main(String[] args) {
        //tree 1
        BinarySearchTree<Integer> tree1 = new BinarySearchTree<>();
        tree1.createTree(new Integer[]{10,5,20,3,8,30,7,9,25});
        //tree 2
        AVLTree<Integer> tree2 = new AVLTree<>();
        tree2.createTree(new Integer[]{10,5,20,3,8,30,7,9,25});
        System.out.println(tree2.remove(30));
    }
}
