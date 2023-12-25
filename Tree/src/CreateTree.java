class Node{
    int data;
    Node left, right;

    public Node(int item){
        data = item;
        left = right = null;
    }
}

class CreateTree{
    Node root;

    CreateTree() {
        root = null;
    }

    //Insert a new node
    void insert(int data){
        root = insertRec (root, data);
    }

    Node insertRec(Node root, int data){
        if(root == null){
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec (root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    //In-order traversal

    void inorder(){
        inorderRec(root);
    }

    void inorderRec(Node root){
        if (root != null) {
            inorderRec(root.left); //traverse on the left sub tree
            System.out.print(root.data + " "); //print the data of root
            inorderRec(root.right); //traverse on the right sub tree
        }
    }

    //Pre-order traversal

    void preorder(){
        preorderRec(root);
    }

    void preorderRec(Node root){
        if (root != null){
            System.out.print(root.data + " "); //print the data of root
            preorderRec(root.left); //traverse on the left sub tree
            preorderRec(root.right); //traverse on the right sub tree
        }
    }

    //Post-order traversal

    void postorder(){
        postorderRec(root);
    }

    void postorderRec(Node root){
        if(root != null){
            postorderRec(root.left); //traverse on the left sub tree
            postorderRec(root.right); //traverse on the right sub tree
            System.out.print(root.data + " "); //print the data of root
        }
    }

    //Search element in tree
    boolean search(int value){
        return searchRec(root, value);
    }

    boolean searchRec(Node root, int value){
        if (root == null){
            return false; //value not found in this sub tree
        }

        if (value == root.data){
            return true; //value found at the current node
        }else if (value < root.data){
            return searchRec(root.left, value); //search in left subtree
        }else{
            return searchRec(root.right, value); //search in right subtree
        }
    }

    //Delete a value from the tree
    void delete(int value){
        root = deleteRec(root, value);
    }

    Node deleteRec(Node root, int value){
        if(root == null){
            return root; //Value not found, nothing delete
        }

        if(value < root.data){
            root.left = deleteRec(root.left, value); //search in left subtree
        }else if(value > root.data){
            root.right = deleteRec(root.right, value);
        }else{
            //Node with only one child or no child
            if (root.left == null) {
                return root.right;    
            }else if(root.right == null){
                return root.left;
            }

            //Node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);

            //Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    int minValue(Node root){
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    public static void main(String[] args) {
        CreateTree tree = new CreateTree();

        //Indert nodes
        tree.insert(45);
        tree.insert(10);
        tree.insert(7);
        tree.insert(90);
        tree.insert(12);
        tree.insert(50);
        tree.insert(13);
        tree.insert(39);
        tree.insert(57);

        //Print in-order traversal
        System.out.println("In-order traversal: ");
        tree.inorder();

        //Print pre-order traversal
        System.out.println("\n\nPre-order traversal: ");
        tree.preorder();

        //Print post-order traversal
        System.out.println("\n\nPost-order traversal: ");
        tree.postorder();

        int searchValue = 12;
        if (tree.search(searchValue)){
            System.out.println("\n\n" + searchValue + " is present in tree.");
        }else{
            System.out.println("\n\n" + searchValue + " is not present in tree.");
        }

        tree.delete(7);
        tree.delete(90);
        tree.delete(10);

        //print in-order traversal after deletion
        System.out.println("\n\nIn-order traversal after deletion: ");
        tree.inorder();
    }
}