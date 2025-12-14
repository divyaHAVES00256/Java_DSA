import java.util.*;
public class LargestBST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }
    static int maxtree = 0;
    static class Info{
        boolean check;
        int size;
        int min;
        int max;

        Info(boolean check, int size, int min, int max){
            this.check = check;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    

    static Info largest(Node root){
        if(root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        } 
        Info l = largest(root.left);
        Info r = largest(root.right);
        int size = l.size + r.size + 1;
        int min = Math.min(root.data, Math.min(l.min, r.min));
        int max = Math.max(root.data, Math.max(l.max, r.max));
        
        //is bst
        boolean isbst = l.check && r.check && (root.data>l.max) && (root.data<r.min);

        //onlly update maxtree when it is a bst
        if(isbst) maxtree = Math.max(maxtree, size);
        System.out.println(maxtree + " "+ isbst + " " + root.data);
        
        return new Info(isbst, size, min, max);
    }
    public static void main(String[] args){

        // Node root = new Node(50);
        // root.left = new Node(30);
        // root.right = new Node(60);
        // root.left.left = new Node(5);
        // root.left.left.left = new Node(1);
        // root.left.left.right = new Node(8);
        // root.left.right = new Node(20);   
        // root.right.left = new Node(45);
        // root.right.right = new Node(70);
        // root.right.right.left = new Node(65);
        // root.right.right.right = new Node(80);

        /*
                  50
                 /  \
               30    60
              / \    / \
             5  20  45  70
            1 8         / \
                      65   80
        */



        Node root = new Node(1);

        root.left = new Node(4);
        root.right = new Node(3);

        root.left.left = new Node(2);
        root.left.right = new Node(4);

        // root.right.left = new Node(2);
        // root.right.right = new Node(5);

        // root.right.right.left = new Node(4);
        // root.right.right.right = new Node(6);

        /*
            1
            / \
            4   3
           / \  / \
           2  4 2   5
                    / \
                    4   6
        */


        System.out.println(largest(root).size);

        System.out.println(maxtree);
    }
}
