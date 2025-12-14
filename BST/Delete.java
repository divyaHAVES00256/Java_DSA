import java.util.*;
public class Delete {
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

    public static Node build(Node root, int val) {
        if(root == null) return new Node(val); //set root node value

        if(val<root.data) root.left = build(root.left, val);
        else root.right = build(root.right, val);

        return root;
    }

    
    static void inorder(Node root, ArrayList<Node> in) {
        if(root == null) return;

        inorder(root.left, in);
        in.add(root);
        inorder(root.right, in);
    }

    static Node search(Node root, int key) {
        if(root == null) return null;

        if(root.data == key){System.out.println("true"); return root;}

        else if(root.data < key) return search(root.right, key);

        else return search(root.left, key);
    }

    static Node parent (Node root, int key) {
        if(root == null || root.data == key) return null; //no parent

        if ((root.left != null && root.left.data == key) ||
        (root.right != null && root.right.data == key)) {
            return root;
        }
            
        Node lefttree = parent(root.left, key);
        if (lefttree != null) {
            return lefttree;
        } else {
            return parent(root.right, key);
        }
    }



    static Node findinordersucc(Node root){
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    static Node delete(Node root, int key) {
        //delete
        if(root == null) return null;
        else if(root.data>key){
            root.left = delete(root.left, key);
        } 
        else if (root.data<key){
            root.right = delete(root.right, key);
        }
        else{
            //0 child
            if(root.left == null && root.right == null){
                return null;
            }
            //1 child
            else if(root.left == null ){
                //child is is right of key
                return root.right;
            }
            else if(root.right == null) {
                //child is is left of key
                return root.left;
            }
            //2 child
            else {
                Node inos = findinordersucc(root.right);
                root.data = inos.data;
                root.right = delete(root.right, inos.data);
            }
        } 
        return root;
    }
    
    public static void main(String[] args) {
        // int[] values = {5, 1, 3, 4, 2, 7};
        // int[] values = {5, 1, 3, 10, 11, 4, 2, 7, 0, 9};

        // Node root = null;

        // for(int val : values) {
        //     root = build(root, val);
        // }


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

        // Node par = parent(root, 18);
        // if(par==null){
        //     System.out.println("null");
        // } else {
        //     System.out.println(par.data);
        // }
        ArrayList<Node> in = new ArrayList<>();
        inorder(root, in);
        for(int i = 0; i<in.size(); i++){
            System.out.print(in.get(i).data + " ");
        }
        System.out.println();
        
        System.out.println(delete(root, 10).data);

        ArrayList<Node> fin = new ArrayList<>();
        inorder(root, fin);
        for(int i = 0; i<fin.size(); i++){
            System.out.print(fin.get(i).data + " ");
        }
    }
}
