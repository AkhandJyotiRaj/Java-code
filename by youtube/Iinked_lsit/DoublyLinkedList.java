public class DoublyLinkedList {
    
    class Node {
        int data;
        Node prev;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    
    Node head = null;
    Node tail = null;
    
    // Add node at the beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    
    // Add node at the end
    public void addLast(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    
    // Insert at specific position
    public void insertAt(int position, int data) {
        if (position <= 0) {
            addFirst(data);
            return;
        }
        
        Node newNode = new Node(data);
        Node current = head;
        int count = 0;
        
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }
        
        if (current == null) {
            addLast(data);
        } else if (current == tail) {
            addLast(data);
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
    }
    
    // Delete first node
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }
    
    // Delete last node
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }
    
    // Delete node with specific value
    public void deleteValue(int data) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        Node current = head;
        
        while (current != null && current.data != data) {
            current = current.next;
        }
        
        if (current == null) {
            System.out.println("Value not found!");
            return;
        }
        
        if (current == head) {
            deleteFirst();
        } else if (current == tail) {
            deleteLast();
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }
    
    // Display list forward
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        Node current = head;
        System.out.print("Forward: ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("NULL");
    }
    
    // Display list backward
    public void displayBackward() {
        if (tail == null) {
            System.out.println("List is empty!");
            return;
        }
        
        Node current = tail;
        System.out.print("Backward: ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("NULL");
    }
    
    // Get size of list
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    // Search for a value
    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        
        System.out.println("=== Doubly Linked List Operations ===");
        
        list.addFirst(10);
        list.addFirst(20);
        list.addLast(30);
        list.addLast(40);
        list.addFirst(5);
        
        list.displayForward();
        list.displayBackward();
        
        System.out.println("\nSize: " + list.size());
        
        list.insertAt(2, 15);
        list.displayForward();
        
        System.out.println("\nSearch 30: " + list.search(30));
        System.out.println("Search 100: " + list.search(100));
        
        list.deleteFirst();
        System.out.println("\nAfter deleting first:");
        list.displayForward();
        
        list.deleteLast();
        System.out.println("\nAfter deleting last:");
        list.displayForward();
        
        list.deleteValue(15);
        System.out.println("\nAfter deleting 15:");
        list.displayForward();
    }
}

