import java.util.ArrayList;
import java.util.Collections;

public class BinarySearchTree<T extends Comparable<T>> {
    
    Node<T> root;

    //create btree
    public void createTree(T[] arr){
        for(T key: arr){
            insert(key);
        }
    }

    //insert methods
    public long insert(T key){
        long start = System.nanoTime();
        Node<T> node = new Node<>(key);
        root = insertHelper(root, node);
        return System.nanoTime() - start;
    }
    private Node<T> insertHelper(Node<T> root, Node<T> node){

        T data = node.data;

        //if there is no tree/subtree, create tree/subtree from root
        if(root == null){
            root = node;
            return root;
        }
        //go left since it's smaller
        else if(data.compareTo(root.data) < 0){
            root.left = insertHelper(root.left, node);
        }
        //go right since it's bigger
        else{
            root.right = insertHelper(root.right, node);
        }

        return root;
    }

    //traverse methods
    public void traverse(int type){
        if(type == 1){
            //pre order traversal
            System.out.print("Pre order Traversal: ");
        }
        else if(type == 2){
            //in order traversal
            System.out.print("In order Traversal: ");
        }
        else if(type == 3){
            //post order traversal
            System.out.print("Post order Traversal: ");
        } 
        traverseHelper(this.root, type);
        System.out.println();
    }
    protected void traverseHelper(Node<T> root, int type){

        if(root != null){
            if(type == 1){
                //pre order traversal
                System.out.print(root.data + ", ");
                traverseHelper(root.left, type);
                traverseHelper(root.right, type);
            }
            else if(type == 2){
                //in order traversal
                traverseHelper(root.left, type);
                System.out.print(root.data + ", ");
                traverseHelper(root.right, type);
            }
            else if(type == 3){
                //post order traversal
                traverseHelper(root.left, type);
                traverseHelper(root.right, type);
                System.out.print(root.data + ", ");
            }            
        }
    }

    //search methods
    public boolean search(T data){
        return searchHelper(root, data);
    }
    private boolean searchHelper(Node<T> root, T data){

        //if it reaches a leaf then return null if not found
        if(root == null){
            return false;
        }
        //found node
        else if(data.compareTo(root.data) == 0){
            return true;
        }
        //go left
        else if(data.compareTo(root.data) < 0){
            return searchHelper(root.left, data);
        }
        //go right
        else{
            return searchHelper(root.right, data);
        }
    }
    protected Node<T> getNode(Node<T> root, T data){
        //if it reaches a leaf then return null if not found
        if(root == null){
            return null;
        }
        //found node
        else if(data.compareTo(root.data) == 0){
            return root;
        }
        //go left
        else if(data.compareTo(root.data) < 0){
            return getNode(root.left, data);
        }
        //go right
        else{
            return getNode(root.right, data);
        }
    }

    //print methods
    public void printTree() {
        printTreeHelper(root, 0);
    }
    protected void printTreeHelper(Node<T> root, int depth) {
        
        //reached leaf note so return
        if (root == null) {
            return;
        }
        //go to the right nodes
        printTreeHelper(root.right, depth + 1);

        //formatting
        for (int i = 0; i < depth; i++) {
            System.out.print("      ");
        }
        System.out.println(root.data);

        //go to the left node
        printTreeHelper(root.left, depth + 1);
    }

    //delete method iterative method
    public void removeNodeIteratively(T key){
        Node<T> curr = root;
        Node<T> parent = null;
        while(curr != null){
            //found node
            if(key.compareTo(curr.data) == 0){
                //check if it's a leaf node
                if(curr.left == null && curr.right == null){
                    if(parent == null){
                        root = null;
                    }
                    //remove reference
                    else if(parent.left == curr){
                        parent.left = null;
                    }
                    else{
                        parent.right = null;
                    }
                    return;
                }
                //has a right child
                else if(curr.left == null){
                    //if parent is null that means it's the root
                    if(parent == null){
                        root = curr.right;
                    }     
                    //if the current is the parent's left then just point to the current's right            
                    else if(parent.left == curr){
                        parent.left = curr.right;
                    }
                    //if the current is the parent's right then just point to the current's right 
                    else{
                        parent.right = curr.right;
                    }
                    return;
                }
                //has a left child
                else if(curr.right == null){
                    if(parent == null){
                        root = null;
                    }                 
                    else if(parent.left == curr){
                        parent.left = curr.left;
                    }
                    else{
                        parent.right = curr.left;
                    }
                    return;
                }
                //has two children
                else{
                    //go right then go all the way left
                    Node<T> successorParent = curr;
                    Node<T> successor = curr.right;
                    //find successor
                    while(successor.left != null){
                        successorParent = successor;
                        successor = successor.left;
                    }
                    curr.data = successor.data;
                    //remove successor
                    if(successorParent == curr){
                        curr.right = successor.right;
                    }       
                    else{
                        successorParent.left = successor.right;
                    }
                    return;             
                }
            }
            //go left
            else if(key.compareTo(curr.data) < 0){
                parent = curr;
                curr = curr.left;
            }
            //go right
            else{
                parent = curr;
                curr = curr.right;
            }
        }
    }

    //delete methods
    public long remove(T key){
        long start = System.nanoTime();
        removeNodeHelper(root, key);
        return System.nanoTime() - start;
    }
    private Node<T> removeNodeHelper(Node<T> root, T key){

        //searching for node
        if(root == null){
            return null;
        }
        //found node
        else if(key.compareTo(root.data) == 0){
            //check if it's a leaf node
            if(root.left == null && root.right == null){
                //delete node
                root = null;
            }
            //check if it has one child node
            //right child
            else if(root.right != null){
                Node <T > min = root.right;
                //find the minimum value onto the right side
                //keep going left until u get a leaf
                while(min.left != null){
                    min = min.left;
                }
                root.data = min.data;
                root.right = removeNodeHelper(root.right, root.data);
            }
            //left child
            else {
                Node<T> max = root.left;
                //find maximum on left side
                //keep going until leaf
                while(max.right != null){
                    max = max.right;
                }
                root.data = max.data;
                root.left = removeNodeHelper(root.left, root.data);

            }
        }
        //go left
        else if(key.compareTo(root.data) < 0){
            root.left = removeNodeHelper(root.left, key);
        }
        //go right
        else{
            root.right = removeNodeHelper(root.right, key);
        }
        return root;        
    }

    //find min and max
    public void findMin(T start){
        Node<T> startNode = getNode(root, start);
        //go all the way left
        while(startNode.left != null){
            startNode = startNode.left;
        }
        System.out.println("Min is " + startNode.data + " from subtree root " + start);
    }
    public void findMax(T start){
        Node<T> startNode = getNode(root, start);
        //go all the way right
        while(startNode.right != null){
            startNode = startNode.right;
        }
        System.out.println("Max is " + startNode.data + " from subtree root " + start);
    }

    //check if tree is BST or not
    public boolean isBST(){
        ArrayList<T> order = new ArrayList<>();
        getInOrder(root, order);
        //check if in order
        for(int i = 1; i < order.size(); ++i){
            if(order.get(i-1).compareTo(order.get(i)) > 0){
                return false;
            }
        }
        return true;
    }
    private void getInOrder(Node<T> root, ArrayList<T> list){
        //in order traversal
        if(root == null){
            return;
        }
        getInOrder(root.left, list);
        list.add(root.data);
        getInOrder(root.right, list);
    }

    //convert to BST
    public BinarySearchTree<T> convertToBST(BinarySearchTree<T> tree){
        ArrayList<T> order = new ArrayList<>();
        getInOrder(tree.root, order);
        //sort the order
        Collections.sort(order);
        //convert
        convertToBSTHelper(tree.root, order, new int[]{0});
        return this;
    }
    private void convertToBSTHelper(Node<T> root, ArrayList<T> list, int[] index){
        //if reached leaf
        if(root == null){
            return;
        }
        //recursion first creating the left subtree
        convertToBSTHelper(root.left, list, index);

        //change node data based on sorted list and index
        root.data = list.get(index[0]);
        index[0]++;

        //creating the right subtree
        convertToBSTHelper(root.right, list, index);
    }
}
