import org.w3c.dom.Node;

public class sizeoftree {
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

    public static int size(Node root) {
        if (root == null)
            return 0;
        return 1 + size(root.left) + size(root.right);
    }

    public static int sumof(Node root) {
        if (root == null)
            return 0;

        return root.val + sumof(root.left) + sumof(root.right);

    }

    public static int maxval(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;
        return Math.max(root.val, Math.max(maxval(root.left), maxval(root.right)));
    }

    public static void preorder(Node root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        Node a = new Node(1);
        Node b = new Node(2);
        root.left = a;
        root.right = b;
        Node c = new Node(3);
        Node d = new Node(4);
        a.left = c;
        a.right = d;
        Node e = new Node(50);
        Node f = new Node(6);
        b.left = e;
        b.right = f;
        // display(root);
        // preorder(root);
        // System.out.println(size(root));
        System.out.println(sumof(root));
        System.out.println(maxval(root));
    }
}

1:21:08 time span
