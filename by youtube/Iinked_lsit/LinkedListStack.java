public class LinkedListStack {
    
    class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node top = null;
    
    // Push operation - Add element at the top
    public void push(int data) {
        Node newNode = new Node(data);
        
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        System.out.println("Pushed: " + data);
    }
    
    // Pop operation - Remove and return top element
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot pop.");
            return -1;
        }
        
        int data = top.data;
        top = top.next;
        System.out.println("Popped: " + data);
        return data;
    }
    
    // Peek operation - View top element without removing
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return top.data;
    }
    
    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }
    
    // Display stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        
        System.out.print("Stack (top to bottom): ");
        Node current = top;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
    
    // Get size of stack
    public int size() {
        int count = 0;
        Node current = top;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    // Search for an element
    public boolean search(int data) {
        Node current = top;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    // Clear stack
    public void clear() {
        top = null;
        System.out.println("Stack cleared!");
    }
    
    // Reverse stack using another stack
    public void reverse() {
        if (isEmpty() || top.next == null) {
            return; // Stack is empty or has only one element
        }
        
        LinkedListStack tempStack = new LinkedListStack();
        
        while (!isEmpty()) {
            tempStack.push(pop());
        }
        
        this.top = tempStack.top;
        System.out.println("Stack reversed!");
    }
    
    // Sort stack (using temporary stack)
    public void sort() {
        if (isEmpty() || top.next == null) {
            return;
        }
        
        LinkedListStack tempStack = new LinkedListStack();
        
        while (!isEmpty()) {
            int temp = pop();
            while (!tempStack.isEmpty() && tempStack.peek() > temp) {
                push(tempStack.pop());
            }
            tempStack.push(temp);
        }
        
        this.top = tempStack.top;
        System.out.println("Stack sorted!");
    }
    
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        
        System.out.println("=== Linked List Stack Implementation ===\n");
        
        System.out.println("1. Pushing elements:");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        
        System.out.println("\n2. Current stack:");
        stack.display();
        
        System.out.println("\n3. Stack size: " + stack.size());
        System.out.println("4. Top element (peek): " + stack.peek());
        
        System.out.println("\n5. Popping elements:");
        stack.pop();
        stack.pop();
        
        System.out.println("\n6. Stack after popping:");
        stack.display();
        
        System.out.println("\n7. Searching for 20: " + stack.search(20));
        System.out.println("   Searching for 100: " + stack.search(100));
        
        System.out.println("\n8. Adding more elements:");
        stack.push(60);
        stack.push(25);
        stack.push(35);
        stack.display();
        
        System.out.println("\n9. Sorting stack:");
        stack.sort();
        stack.display();
        
        System.out.println("\n10. Reversing stack:");
        stack.reverse();
        stack.display();
        
        System.out.println("\n11. Final stack operations:");
        while (!stack.isEmpty()) {
            stack.pop();
        }
        
        System.out.println("\n12. Trying to pop from empty stack:");
        stack.pop();
    }
}

