import java.util.*;
public class Search {
    static class Node{
        int data;
        Node right;
        Node left;
        
        Node(int data){
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    // public static void build(Node root, ArrayList<Node> val, int i){
    //     if(val.size() == 0) return;

    //     if(i == 0) {
    //         root = val.get(i);
    //         build(root, val, i+1);
    //     }

    //     if(val.get(i).data<root.data){
    //         if(root.left!=null)
    //             build(root.left, val, i+1);
    //         root.left = val.get(i);
    //     } else {
    //         if(root.right!=null)
    //             build(root.right, val, i+1);
    //         root.right = val.get(i);
    //     }
    // }

    public static Node build(Node root, int val) {
        if(root == null) return new Node(val); //set root node value

        if(val<root.data) root.left = build(root.left, val);
        else root.right = build(root.right, val);

        return root;
    }

    static void inorder(Node root){
        //lnr
        if(root == null) return;

        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    static Node search(Node root, int key) {
        if(root == null) return null;

        if(root.data == key){System.out.println("true"); return root;}

        else if(root.data < key) return search(root.right, key);

        else return search(root.left, key);
    }
    public static void main(String[] args) {
        // int[] values = {5, 1, 3, 4, 2, 7};
        int[] values = {5, 1, 3, 10, 11, 4, 2, 7, 0, 9};

        Node root = null;

        for(int val : values) {
            root = build(root, val);
        }

        // inorder(root);

        Node ans = search(root, 90);

        if(ans == null) System.out.println("false");
        else System.out.println(ans.data);
    }
}
