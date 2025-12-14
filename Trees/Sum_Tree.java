public class Sum_Tree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int sumTree(Node root) {
        // if (root == null) return 0;
        // int left = sumTree(root.left);
        // int right = sumTree(root.right);
        // if (left == 0 && right == 0) return root.data;
        // return left + right;

        if (root == null) return 0;
        int left = sumTree(root.left);
        int right = sumTree(root.right);

        int data = root.data; //this data will (root.data in particular) be used in leafnode

        if (root.left == null) {
            root.data = root.right.data;
        } else if (root.right == null) {
            root.data = root.left.data;

        } else if(root.left == null && root.right == null) {
            root.data = left+right;
        } else {
            root.data = left + right + root.left.data + root.right.data; //change node data value
        }
        // System.out.println(root.data);
        return data;
    }

    public static void main(String[] args) {
        // Node root = new Node(1);
        // root.left = new Node(2);
        // root.right = new Node(3);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);
        // root.left.right.right = new Node(8);
        // root.left.right.right.right = new Node(9);

        Node root = new Node(1);
        root.left = new Node(2);
        // root.right = new Node(3);
        // root.right.left = new Node(10);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);

        System.out.println(sumTree(root));
    }
}
