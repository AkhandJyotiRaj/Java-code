public class inorder {
    
    public static class Node {
        int val;
        Node left; // null;
        Node right;

        Node(int val) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void inorderr(Node root) {
        if (root == null)
            return;
        inorderr(root.left);
        System.out.print(root.val+" ");
        inorderr(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        root.left = a;
        root.right = b;
        Node c = new Node(4);
        Node d = new Node(5);
        a.left = c;
        a.right = d;
        Node e = new Node(6);
        Node f = new Node(7);
        b.left = e;
        b.right = f;
    inorderr(root);
    }
}
