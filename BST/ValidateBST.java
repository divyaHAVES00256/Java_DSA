

public class ValidateBST{
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

    static boolean check(Node root, Node min, Node max){
        if(root == null) return true;
        
        if(min!=null && min.data>=root.data){return false; }
        if(max!=null && max.data<=root.data) {return false; }

        return check(root.left, min, root)&& check(root.right, root, max);

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

        System.out.println(check(root, null, null));
    }
    
}