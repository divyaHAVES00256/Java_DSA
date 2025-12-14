import java.util.ArrayList;

public class RootToLeafPaths{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data= data;
            this.left = null;
            this.right = null;
        }
    }

    static void paths(Node root, ArrayList<Integer> ar){
        if(root==null){
            return;
        }
        ar.add(root.data);
        if(root.left == null && root.right==null) {
            System.out.println(ar);
        }
        System.out.println(ar + " left");
        paths(root.left, ar);
        System.out.println(ar + " right");
        paths(root.right, ar);
        System.out.println(ar.remove(ar.size()-1) + " remove ");
    }
    public static void main(String[] args){
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.left.left = new Node(1);
        root.left.right = new Node(7);
        root.right.left = new Node(12);
        root.right.right = new Node(18);

        // Structure:
        /*
                10
               /  \
              5    15
             / \   / \
            3   7 12 18
           1
        */

        paths(root, new ArrayList<Integer>());
    }
}