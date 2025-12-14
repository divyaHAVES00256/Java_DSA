import java.util.*;
public class Kth_Ancestor {
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

    static boolean path(Node root, Node n, ArrayList<Node> a){
        if(root == null){
            return false;
        }
        if(root == n){
            a.add(root);
            return true;
        }

        a.add(root);
        if(path(root.left, n, a) == false && path(root.right, n, a) == false){
            if(!a.isEmpty()){
                a.remove(a.size()-1);
            }
            return false;
        }  else{
            return true;
        }

    }

    static int kthNode(Node root, Node n, int k){
        ArrayList<Node> a = new ArrayList<>();

        path(root, n, a);
        for(int i = 0; i<a.size(); i++){
            System.out.println(a.get(i).data);
           
        }

        if(a.size()<=k){
            return -1;
        }

       return a.get(a.size()-k-1).data;
    }

    static int kthNode2(Node root, Node n, int k){
        // Hint 1: You need to track the distance from the target node up to the root.
        // Hint 2: When you find the target node, return 0 (distance to itself).
        // Hint 3: As you unwind recursion, increment the distance.
        // Hint 4: If the distance equals k, print or return the ancestor.
        // Hint 5: Use the return value to propagate the distance up the tree.

        // if(root == null) return -1;
        // if(root == n) return 0;
        // int leftdis = kthNode2(root.left, n, k);
        // int rightdis = kthNode2(root.right, n, k);
        // if(leftdis == -1 && rightdis == -1) return -1;
        // int max = Math.max(leftdis, rightdis);
        // if(max+1 == k){
        //     System.out.println(root.data);
        // }
        // return max+1; //max here basially giving the distance 

        // int currDist = -1;
        // if(leftdis != -1) currDist = leftdis + 1;
        // else if(rightdis != -1) currDist = rightdis + 1;
        // if(currDist == k) {
        //     System.out.println(root.data + " ans2 "); //this gives kth
        // }
        // return currDist; //node to root distance

        if(root == null) return -1;
        if(root == n) return 0;

        int left = kthNode2(root.left, n, k);;
        int right = kthNode2(root.right, n, k);
        
        if(left == -1 && right == -1){
            return -1;
        } 

        int max =  Math.max(left, right);

        if(max+1 == k) {
            return root.data;
        } 
         return max+1;
        
        
        
    }

    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(8);
        root.left.right.right.right = new Node(9);

        System.out.println(kthNode2(root,   root.left.right.right.right , 1) + " ans ");
    }


}
