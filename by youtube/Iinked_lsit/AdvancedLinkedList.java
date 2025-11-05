public class AdvancedLinkedList {
    
    class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    Node head = null;
    
    // Add node at the end
    public void add(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    
    // Display list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }
    
    // 1. Reverse Linked List (Iterative)
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
    
    // 2. Reverse Linked List (Recursive)
    public Node reverseRecursive(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        
        Node rest = reverseRecursive(node.next);
        node.next.next = node;
        node.next = null;
        return rest;
    }
    
    public void reverseRecursive() {
        head = reverseRecursive(head);
    }
    
    // 3. Find Middle Node
    public int findMiddle() {
        if (head == null) {
            return -1;
        }
        
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow.data;
    }
    
    // 4. Detect Cycle (Floyd's Cycle Detection)
    public boolean hasCycle() {
        if (head == null) {
            return false;
        }
        
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        
        return false;
    }
    
    // 5. Find Nth Node from End
    public int findNthFromEnd(int n) {
        if (head == null) {
            return -1;
        }
        
        Node first = head;
        Node second = head;
        
        // Move first pointer n positions ahead
        for (int i = 0; i < n; i++) {
            if (first == null) {
                return -1; // n is greater than list length
            }
            first = first.next;
        }
        
        // Move both pointers until first reaches end
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        return second.data;
    }
    
    // 6. Remove Duplicates from Sorted List
    public void removeDuplicates() {
        Node current = head;
        
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }
    
    // 7. Merge Two Sorted Lists
    public static AdvancedLinkedList mergeSorted(AdvancedLinkedList list1, AdvancedLinkedList list2) {
        AdvancedLinkedList merged = new AdvancedLinkedList();
        Node dummy = merged.new Node(0);
        Node tail = dummy;
        
        Node l1 = list1.head;
        Node l2 = list2.head;
        
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                tail.next = merged.new Node(l1.data);
                l1 = l1.next;
            } else {
                tail.next = merged.new Node(l2.data);
                l2 = l2.next;
            }
            tail = tail.next;
        }
        
        while (l1 != null) {
            tail.next = merged.new Node(l1.data);
            l1 = l1.next;
            tail = tail.next;
        }
        
        while (l2 != null) {
            tail.next = merged.new Node(l2.data);
            l2 = l2.next;
            tail = tail.next;
        }
        
        merged.head = dummy.next;
        return merged;
    }
    
    // 8. Check if list is Palindrome
    public boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        
        // Find middle
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse second half
        Node secondHalf = slow.next;
        slow.next = null;
        
        Node prev = null;
        Node current = secondHalf;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        // Compare both halves
        Node first = head;
        Node second = prev;
        while (first != null && second != null) {
            if (first.data != second.data) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        
        return true;
    }
    
    // 9. Get size
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Advanced Linked List Operations ===\n");
        
        AdvancedLinkedList list = new AdvancedLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        
        System.out.println("Original List:");
        list.display();
        
        System.out.println("\n1. Middle Element: " + list.findMiddle());
        System.out.println("2. 3rd from end: " + list.findNthFromEnd(3));
        System.out.println("3. Has Cycle: " + list.hasCycle());
        
        System.out.println("\n4. Reversing list (iterative):");
        list.reverse();
        list.display();
        
        System.out.println("\n5. Reversing back (recursive):");
        list.reverseRecursive();
        list.display();
        
        AdvancedLinkedList list2 = new AdvancedLinkedList();
        list2.add(1);
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(3);
        list2.add(4);
        
        System.out.println("\n6. List with duplicates:");
        list2.display();
        list2.removeDuplicates();
        System.out.println("After removing duplicates:");
        list2.display();
        
        AdvancedLinkedList list3 = new AdvancedLinkedList();
        list3.add(1);
        list3.add(2);
        list3.add(2);
        list3.add(1);
        
        System.out.println("\n7. Palindrome check:");
        list3.display();
        System.out.println("Is Palindrome: " + list3.isPalindrome());
        
        AdvancedLinkedList list4 = new AdvancedLinkedList();
        list4.add(1);
        list4.add(3);
        list4.add(5);
        
        AdvancedLinkedList list5 = new AdvancedLinkedList();
        list5.add(2);
        list5.add(4);
        list5.add(6);
        
        System.out.println("\n8. Merging sorted lists:");
        System.out.print("List 1: ");
        list4.display();
        System.out.print("List 2: ");
        list5.display();
        AdvancedLinkedList merged = mergeSorted(list4, list5);
        System.out.print("Merged: ");
        merged.display();
    }
}

