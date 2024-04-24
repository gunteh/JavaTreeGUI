public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T>{
    Node<T> root;

    @Override
    public long insert(T key){
        long start = System.currentTimeMillis();
        root = insertHelper(root, new Node<>(key));
        return System.currentTimeMillis() - start;
    }
    private Node<T> insertHelper(Node<T> root, Node<T> node){
        //normal insertion
        if(root == null){
            root = node;
            return root;
        }
        else if(node.data.compareTo(root.data) < 0){
            root.left = insertHelper(root.left, node);
        }
        else{
            root.right = insertHelper(root.right, node);
        }

        // Update heights
        root.height = 1 + Integer.max(height(root.left), height(root.right));

        // Check balance and perform rotations if necessary
        int balance = findBalance(root);
        //System.out.println(root.data + " " + balance);

        //rotate
        //LL
        if(balance > 1 && (node.data.compareTo(root.left.data) < 0)){
            //rotating
            Node<T> newNode = root.left.right; //storing B-Right
            root.left.right = root; //B-Right = A
            root = root.left; //B = root
            root.right.left = newNode; //A.left = newNode

            // Update heights
            root.right.height = root.left.height;
        }
        //LR
        else if(balance > 1 && (node.data.compareTo(root.left.data) > 0)){
            Node<T> newNode1 = root.left.right.left;
            Node<T> newNode2 = root.left.right.right;
            root.left.right.left = root.left;
            root.left.right.right = root;
            root = root.left.right;
            root.left.right = newNode1;
            root.right.left = newNode2;

            //update heights;
            root.height++;
            root.left.height--;
            root.right.height = root.left.height;
        }
        //RR
        else if(balance < -1 && (node.data.compareTo(root.right.data) > 0)){
            //rotating
            Node<T> newNode = root.right.left; //storing center left
            root.right.left = root;
            root = root.right;
            root.left.right = newNode;

            // Update heights
            root.left.height = root.right.height;

            return root; //new root after rotation
        }
        //RL
        else if(balance < -1 && (node.data.compareTo(root.right.data) < 0)){
            Node<T> newNode1 = root.right.left.left;
            Node<T> newNode2 = root.right.left.right;
            root.right.left.left = root;
            root.right.left.right = root.right;
            root = root.right.left;
            root.left.right = newNode1;
            root.right.left = newNode2;

            //update heights;
            root.height++;
            root.right.height--;
            root.left.height = root.right.height;
        }
        return root; //maybe new root if rotated
    } 

    //removing nodes
    @Override
    public long remove(T key){
        long start = System.currentTimeMillis();
        Node<T> node = super.getNode(root, key);
        if(node == null){
            System.out.println("Could not find node " + key);
        }
        else{            
            removeNodeHelper(root, super.getNode(root, key));  
        }
        return System.currentTimeMillis() - start;
    }
    private Node<T> removeNodeHelper(Node<T> root, Node<T> key){
        //normal deletion of node
        if(root == null){
            return null;
        }
        else if(key.data.compareTo(root.data) == 0){
            if(root.left == null && root.right == null){
                root = null;
            }
            else if(root.right != null){
                Node <T > min = root.right;
                while(min.left != null){
                    min = min.left;
                }
                root.data = min.data;
                root.right = removeNodeHelper(root.right, root);
            }
            else {
                Node<T> max = root.left;
                while(max.right != null){
                    max = max.right;
                }
                root.data = max.data;
                root.left = removeNodeHelper(root.left, root);

            }
        }
        else if(key.data.compareTo(root.data) < 0){
            root.left = removeNodeHelper(root.left, key);
        }
        else{
            root.right = removeNodeHelper(root.right, key);
        }

        if(root != null){            
            //updating heights            
            root.height = 1 + Integer.max(height(root.left), height(root.right));
            //get balance
            int balance = findBalance(root);
            if(balance > 1 && (key.data.compareTo(root.left.data) < 0)){
                //rotating
                Node<T> newNode = root.left.right;
                root.left.right = root;
                root = root.left;
                root.right.left = newNode; 
    
                // Update heights
                root.right.height = root.left.height;
            }
            //LR
            else if(balance > 1 && (key.data.compareTo(root.left.data) > 0)){
                Node<T> newNode1 = root.left.right.left;
                Node<T> newNode2 = root.left.right.right;
                root.left.right.left = root.left;
                root.left.right.right = root;
                root = root.left.right;
                root.left.right = newNode1;
                root.right.left = newNode2;
    
                //update heights;
                root.height++;
                root.left.height--;
                root.right.height = root.left.height;
            }
            //RR
            else if(balance < -1 && (key.data.compareTo(root.right.data) > 0)){
                //rotating
                Node<T> newNode = root.right.left;
                root.right.left = root;
                root = root.right;
                root.left.right = newNode;
    
                // Update heights
                root.left.height = root.right.height;
            }
            //RL
            else if(balance < -1 && (key.data.compareTo(root.right.data) < 0)){
                Node<T> newNode1 = root.right.left.left;
                Node<T> newNode2 = root.right.left.right;
                root.right.left.left = root;
                root.right.left.right = root.right;
                root = root.right.left;
                root.left.right = newNode1;
                root.right.left = newNode2;
    
                //update heights;
                root.height++;
                root.right.height--;
                root.left.height = root.right.height;
            }
        }
        return root;   
    }

    //get height
    private int height(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }
    //finds balance
    private int findBalance(Node<T> node) {
        if (node == null){
            return 0;
        }           
        return height(node.left) - height(node.right);
    }

    //---------------------------------------------------
    @Override
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
        super.traverseHelper(root, type);
        System.out.println();
    }
    @Override
    public void printTree() {
        super.printTreeHelper(root, 0);
    }
}
