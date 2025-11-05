public class BinaryTree {
    
    class Node {
        int data;
        Node left;
        Node right;
        
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    Node root = null;
    
    // Insert node in Binary Search Tree
    public Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        
        return root;
    }
    
    public void insert(int data) {
        root = insert(root, data);
    }
    
    // Search for a value
    public boolean search(Node root, int data) {
        if (root == null) {
            return false;
        }
        
        if (root.data == data) {
            return true;
        }
        
        if (data < root.data) {
            return search(root.left, data);
        } else {
            return search(root.right, data);
        }
    }
    
    public boolean search(int data) {
        return search(root, data);
    }
    
    // Inorder Traversal (Left, Root, Right)
    public void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }
    
    public void inorder() {
        System.out.print("Inorder: ");
        inorderTraversal(root);
        System.out.println();
    }
    
    // Preorder Traversal (Root, Left, Right)
    public void preorderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }
    
    public void preorder() {
        System.out.print("Preorder: ");
        preorderTraversal(root);
        System.out.println();
    }
    
    // Postorder Traversal (Left, Right, Root)
    public void postorderTraversal(Node root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }
    
    public void postorder() {
        System.out.print("Postorder: ");
        postorderTraversal(root);
        System.out.println();
    }
    
    // Calculate height of tree
    public int height(Node root) {
        if (root == null) {
            return -1;
        }
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public int height() {
        return height(root);
    }
    
    // Count total nodes
    public int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    public int countNodes() {
        return countNodes(root);
    }
    
    // Count leaf nodes
    public int countLeaves(Node root) {
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        return countLeaves(root.left) + countLeaves(root.right);
    }
    
    public int countLeaves() {
        return countLeaves(root);
    }
    
    // Find minimum value
    public int findMin(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        
        while (root.left != null) {
            root = root.left;
        }
        
        return root.data;
    }
    
    public int findMin() {
        return findMin(root);
    }
    
    // Find maximum value
    public int findMax(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        
        while (root.right != null) {
            root = root.right;
        }
        
        return root.data;
    }
    
    public int findMax() {
        return findMax(root);
    }
    
    // Delete a node
    public Node deleteNode(Node root, int data) {
        if (root == null) {
            return root;
        }
        
        if (data < root.data) {
            root.left = deleteNode(root.left, data);
        } else if (data > root.data) {
            root.right = deleteNode(root.right, data);
        } else {
            // Node to delete found
            
            // Case 1: Node with no children (leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }
            
            // Case 2: Node with one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            
            // Case 3: Node with two children
            // Find inorder successor (smallest in right subtree)
            root.data = findMin(root.right);
            root.right = deleteNode(root.right, root.data);
        }
        
        return root;
    }
    
    public void delete(int data) {
        root = deleteNode(root, data);
    }
    
    // Level Order Traversal (Breadth First)
    public void levelOrder() {
        if (root == null) {
            System.out.println("Tree is empty!");
            return;
        }
        
        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);
        
        System.out.print("Level Order: ");
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");
            
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        System.out.println();
    }
    
    // Check if tree is empty
    public boolean isEmpty() {
        return root == null;
    }
    
    // Display tree structure (simple visualization)
    public void displayTree() {
        System.out.println("\nTree Structure:");
        displayTree(root, "", true);
    }
    
    private void displayTree(Node root, String prefix, boolean isLast) {
        if (root != null) {
            System.out.println(prefix + (isLast ? "└── " : "├── ") + root.data);
            
            if (root.left != null || root.right != null) {
                if (root.right != null) {
                    displayTree(root.right, prefix + (isLast ? "    " : "│   "), false);
                }
                if (root.left != null) {
                    displayTree(root.left, prefix + (isLast ? "    " : "│   "), true);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        System.out.println("=== Binary Search Tree Operations ===\n");
        
        // Insert nodes
        System.out.println("1. Inserting nodes: 50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45");
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        tree.insert(10);
        tree.insert(25);
        tree.insert(35);
        tree.insert(45);
        
        // Display tree structure
        tree.displayTree();
        
        // Traversals
        System.out.println("\n2. Tree Traversals:");
        tree.inorder();
        tree.preorder();
        tree.postorder();
        tree.levelOrder();
        
        // Tree properties
        System.out.println("\n3. Tree Properties:");
        System.out.println("Height: " + tree.height());
        System.out.println("Total Nodes: " + tree.countNodes());
        System.out.println("Leaf Nodes: " + tree.countLeaves());
        System.out.println("Minimum Value: " + tree.findMin());
        System.out.println("Maximum Value: " + tree.findMax());
        
        // Search operations
        System.out.println("\n4. Search Operations:");
        System.out.println("Search 40: " + tree.search(40));
        System.out.println("Search 100: " + tree.search(100));
        System.out.println("Search 25: " + tree.search(25));
        
        // Delete operations
        System.out.println("\n5. Deleting node 20:");
        tree.delete(20);
        tree.displayTree();
        tree.inorder();
        
        System.out.println("\n6. Deleting node 50 (root):");
        tree.delete(50);
        tree.displayTree();
        tree.inorder();
        
        System.out.println("\n7. Final Tree Properties:");
        System.out.println("Height: " + tree.height());
        System.out.println("Total Nodes: " + tree.countNodes());
        System.out.println("Leaf Nodes: " + tree.countLeaves());
    }
}

