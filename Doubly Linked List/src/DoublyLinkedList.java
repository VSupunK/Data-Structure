public class DoublyLinkedList {
    //Create Node class to represent a node of the DLL
    class Node{
        int data;
        Node previous;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }
    //-------------------------------------------------------------------------------------------

    //head & tail of the node set to null
    Node head, tail = null;

    //Create addNode() to add a node to the list
    public void addNode(int data){
        Node newNode = new Node(data);

        //Check if list is empty
        if(head == null){
            //both head and tail will point to newNode
            head = tail = newNode;
            //head'd previous will point to null
            head.previous = null;
            //tail's next will point to nill
            tail.next = null;
        }
        else{
            //newNode will be added after tail, that tail's next will point to newNode
            tail.next = newNode;
            //newNode's previous will point to the null
            newNode.previous = tail;
            //newNode will become new tail of the list
            tail = newNode;
            //As it is last node, tail's next will point to null
            tail.next = null;
        }
    }
    //-------------------------------------------------------------------------------------------

    //Insert data at beginning
    public void insertAtFront(int data){
        //create newNode with the data
        Node newNode = new Node(data);
        //if the list is empty, the new node becomes both the head and tail
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            //set the next of new node to the current head
            newNode.next = head;
            //set the next of newNode to the current head
            newNode.next = head;
            //set the previous of  the current head to the newNode
            head.previous = newNode;
            //Update the head to point to the newNode
            head = newNode;
        }
    }
    //-------------------------------------------------------------------------------------------

    //Insert value after a given position
    public void insertAfter(int prevNodeData, int data){
        //Create a new node with the given data
        Node newNode = new Node(data);

        //Set current node to the head 
        Node currNode = head;

        while (currNode != null && currNode.data != prevNodeData) {
            currNode = currNode.next;
        }

        if(currNode == null){
            System.out.println("Given node is not found!");
        }

        //if the current is the last node, make the newNode the new tail
        if(currNode.next == null){
            currNode.next = newNode;
            newNode.previous = currNode;
            tail = newNode;
        }
        else{
            Node next = currNode.next;
            currNode.next = newNode;
            newNode.next = next;
            next.previous = newNode;
        }
    }
    //-------------------------------------------------------------------------------------------

    //display() -to print our list
    public void displayList(){
        //current node will point to head
        Node currNode = head;
        if (head == null) {
            System.out.println("List is empty...");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }
    //-------------------------------------------------------------------------------------------

    //Remove the item at front of the doubly linkedlist
    public int removeFront(){
        if(head == null){
            System.out.println("List is empty...");
            return -1;
        }

        int deleteData = head.data;
        Node nextNode = head.next;

        if(nextNode != null){
            nextNode.previous = null;
        }

        head = nextNode;
        return deleteData;
    }
    //-------------------------------------------------------------------------------------------

    //Remove the item at the end of the doubly linked list
    public int removeBack(){

        if(head == null){
            System.out.println("List is empty...");
            return -1;
        }
        int deleteData = tail.data;
        Node prevNode = tail.previous;

        if(prevNode != null){
            prevNode.next = null;
        }
        tail.previous = null;
        tail = prevNode;
        return deleteData;
    }
    //-------------------------------------------------------------------------------------------

    //Remove an item with given value 'key'
    public void remove(int key){
        if (head == null){
            System.out.println("List is empty");
            return;
        }

        Node currNode = head;
        while (currNode != null && currNode.data != key) {
            currNode = currNode.next;
        }

        if(currNode == null){
            System.out.print("Key is not found");
            return;
        }

        if(currNode.previous == null){
            removeFront();
        }
        else if(currNode.next == null){
            removeBack();
        }
        else{
            Node nextNode = currNode.next;
            Node prevNode = currNode.previous;

            prevNode.next = nextNode;
            nextNode.previous = prevNode;

            currNode.previous = null;
            currNode.next = null;
            currNode = null;
        }
    }
    //-------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        DoublyLinkedList dlist = new DoublyLinkedList();

        //Add node to the list
        dlist.addNode(10);
        dlist.addNode(20);
        dlist.addNode(30);
        dlist.addNode(40);
        dlist.addNode(50);

        //display the node present in the list
        dlist.displayList();

        //Insert data to the beginning
        dlist.insertAtFront(5);
        dlist.displayList();

        //Insert data to a givan poesition
        dlist.insertAfter(20, 25);
        dlist.displayList();

        dlist.addNode(60);
        dlist.displayList();

        //Remove node at the front
        dlist.removeFront();
        dlist.displayList();

        //Remove node at the end
        dlist.removeBack();
        dlist.displayList();

        //Remove an item with value 'key = 30'
        dlist.remove(30);
        dlist.displayList();
    }
}
