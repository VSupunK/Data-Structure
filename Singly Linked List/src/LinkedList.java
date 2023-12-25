public class LinkedList{
    Node head;

    static class Node{
        int data;
        Node next;

        //constructor
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }


    //Date insert to last
    public  void InsertData(int data){
        Node newNode = new Node(data);
        
        if(head == null){
            head = newNode;
            newNode.next = null;
        }

        Node currentNode = head;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
        newNode.next = null;
    }
    //---------------------------------------------------------------------------------

    //Print linked list
    public void printLinkedList(){
        Node currNode = head;

        System.out.println("Print Linked List : ");
        while(currNode != null){
                System.out.print(currNode.data + " ");
                currNode = currNode.next;
            }
        System.out.println();
    }
    //---------------------------------------------------------------------------------

    //Insert data at the beginning of the linked list
    public void addDataFront(int data){
        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;

        System.out.println("Linked List after inserting data to the front: ");
    }
    //---------------------------------------------------------------------------------

    //Insert data after given node
    public void insertAfter(Node prevNode, int data){
        Node newNode = new Node(data);
        
        if(prevNode == null){
            System.out.println("The given previous node cannot be null");
            return;
        }
        System.out.println("Linked list after inserting new data after given node");
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }
    //---------------------------------------------------------------------------------

    //Insert data befor given node
    public void insertBefore(Node nextNode, int data){
        Node newNode = new Node(data);

        if(nextNode == null || head == null){
            System.out.println("The given node or linked list cannot be null");
            return;
        }
        System.out.println("Linked list after inserting new data before given node");
        newNode.next = nextNode;

        if(head == nextNode){
            newNode.next = head;
            head = newNode;
            return;
        }

        Node currNode = head;
        while (currNode.next != nextNode) {
            currNode = currNode.next;
        }
        newNode.next = nextNode;
        currNode.next = newNode;
    }
    //---------------------------------------------------------------------------------

    //Remove given node from linked list
    public void removeNode(Node nodeToRemove){
        if(head == null || nodeToRemove == null){
            System.out.println("Head and given node cannot be null");
            return;
        }
        
        if(head == nodeToRemove){
            head = head.next;
            return;
        }

        Node currentNode = head;
        while (currentNode != null && currentNode.next != nodeToRemove) {
            currentNode = currentNode.next;
        }

        if (currentNode != null) {
            currentNode.next = nodeToRemove.next;
        }
    }


    public static void main(String[] args) {
        LinkedList newLL = new LinkedList();

        newLL.InsertData(20);
        newLL.InsertData(30);
        newLL.InsertData(50);
        newLL.InsertData(60);
        newLL.InsertData(70);

        newLL.printLinkedList();

        newLL.addDataFront(10);
        newLL.printLinkedList();


    // Inserting data after the node containing value 40
        Node nodeToInsertAfter = newLL.head.next.next; // Node containing value 40
        newLL.insertAfter(nodeToInsertAfter, 40);
        
        newLL.printLinkedList();
    
    // Inserting data before the node containing value 45
        Node nodeToInsertBefore = newLL.head.next.next.next.next;
        newLL.insertBefore(nodeToInsertBefore, 45);
        newLL.printLinkedList();

    //Remove a 2nd node
        Node nodeToRemove = newLL.head.next.next;
        newLL.removeNode(nodeToRemove);
        newLL.printLinkedList();
    }
}