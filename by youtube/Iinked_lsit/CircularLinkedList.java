public class CircularLinkedList {
    
    class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
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
            newNode.next = head; // Circular reference
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head; // Maintain circular reference
        }
    }
    
    // Add node at the end
    public void addLast(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = tail = newNode;
            newNode.next = head; // Circular reference
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Maintain circular reference
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
        
        if (head == null) {
            addFirst(data);
            return;
        }
        
        while (count < position - 1 && current.next != head) {
            current = current.next;
            count++;
        }
        
        if (current == tail) {
            addLast(data);
        } else {
            newNode.next = current.next;
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
            tail.next = head; // Maintain circular reference
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
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = head;
            tail = current;
        }
    }
    
    // Delete node with specific value
    public void deleteValue(int data) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        Node current = head;
        
        // If head node contains the value
        if (head.data == data) {
            deleteFirst();
            return;
        }
        
        // Search for the node
        while (current.next != head && current.next.data != data) {
            current = current.next;
        }
        
        if (current.next == head) {
            System.out.println("Value not found!");
        } else if (current.next == tail) {
            deleteLast();
        } else {
            current.next = current.next.next;
        }
    }
    
    // Display list
    public void display() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        Node current = head;
        System.out.print("Circular List: ");
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(back to head)");
    }
    
    // Display list (limited iterations to avoid infinite loop)
    public void displayLimited(int iterations) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        Node current = head;
        System.out.print("Circular List (showing " + iterations + " cycles): ");
        int count = 0;
        int maxCount = iterations * size();
        while (count < maxCount) {
            System.out.print(current.data + " -> ");
            current = current.next;
            count++;
        }
        System.out.println("...");
    }
    
    // Get size of list
    public int size() {
        if (head == null) {
            return 0;
        }
        
        int count = 1;
        Node current = head;
        while (current.next != head) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    // Search for a value
    public boolean search(int data) {
        if (head == null) {
            return false;
        }
        
        Node current = head;
        do {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        } while (current != head);
        
        return false;
    }
    
    // Check if list is circular (always true for this implementation)
    public boolean isCircular() {
        return head != null && tail != null && tail.next == head;
    }
    
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        
        System.out.println("=== Circular Linked List Operations ===");
        
        list.addFirst(10);
        list.addFirst(20);
        list.addLast(30);
        list.addLast(40);
        list.addFirst(5);
        
        list.display();
        System.out.println("\nSize: " + list.size());
        System.out.println("Is Circular: " + list.isCircular());
        
        list.insertAt(2, 15);
        list.display();
        
        System.out.println("\nSearch 30: " + list.search(30));
        System.out.println("Search 100: " + list.search(100));
        
        list.deleteFirst();
        System.out.println("\nAfter deleting first:");
        list.display();
        
        list.deleteLast();
        System.out.println("\nAfter deleting last:");
        list.display();
        
        list.deleteValue(15);
        System.out.println("\nAfter deleting 15:");
        list.display();
        
        System.out.println("\nDisplaying 3 cycles:");
        list.displayLimited(3);
    }
}

