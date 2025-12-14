import java.util.*;

import javax.swing.text.StyledEditorKit;
public class PrintRange {
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

    static void inorder(Node root, ArrayList<Node> a){
        if(root == null) return;

        inorder(root.left, a);
        a.add(root);
        inorder(root.right, a);
    }

    // static void printRange(Node root, int n1, int n2){
    //     ArrayList<Node> a = new ArrayList<>();
    //     inorder(root, a);
    //     for(int i = 0; i<a.size(); i++){
    //         int val = a.get(i).data;
    //         if(val>=n1 && val<=n2){
    //             System.out.print(val + " ");
    //         }
    //     }
    // }

    // static void printRange2(Node root, int n1, int n2){
    //     if(root == null) return;

    //     printRange2(root.left, n1, n2);
    //     if(root.data >= n1 && root.data<=n2) System.out.print(root.data + " ");
    //     printRange2(root.right, n1, n2);
    // }

    static void printRange(Node root, int n1, int n2){
        if(root == null) return;
        if(root.data<=n2 && root.data>=n1){
            System.out.println(root.data);
            printRange(root.left, n1, n2);
            printRange(root.right, n1, n2);

        } else if(root.data>n2) {
            if(root.left!=null)
                printRange(root.left, n1, n2);
        } else if(root.data<n1){
            if(root.right!=null)
                printRange(root.right, n1, n2);
        }
    }
   
    
    public static void main(String[] args) {
       
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.left.left = new Node(1);
        // root.left.right = new Node(7);
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

        printRange(root, 5, 13);
    }
}
