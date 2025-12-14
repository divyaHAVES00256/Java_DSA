import java.util.ArrayList;
import java.util.*;

public class Min_Nodes_Distance{
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
    //path from root to node
    static boolean path(Node root, Node n, ArrayList<Node> path){
        if(root == null) {
            return false;
        }
        if(root == n) {
            path.add(root);
            return true;
        }

        //insert
        path.add(root);

        //chk whter to remove inserted node
        if(path(root.left, n, path)==false && path(root.right, n, path)==false){
            if(!path.isEmpty()){
                path.remove(path.size()-1);
            }
            return false;
        } else {
            return true;
        }
    }
    //find lowest common ancestor
    static int minDistance(Node root, Node n1, Node n2) {
        ArrayList<Node> p1 = new ArrayList<>();
        ArrayList<Node> p2 = new ArrayList<>();

        boolean path1 = path(root, n1, p1);
        for(int i = 0; i<p1.size(); i++){
            System.out.print( p1.get(i).data + " ");
        }
        System.out.println();
        

        boolean path2 = path(root, n2, p2);
        for(int i = 0; i<p2.size(); i++){
            System.out.print( p2.get(i).data + " ");
        }
        System.out.println();

        if(path1 == false || path2 == false){
            return -1;
        }

        int ans  = -1;
        int lcaIndex = -1;

        for(int i = 0; i < p1.size() && i < p2.size(); i++) {
            if(p1.get(i) == p2.get(i)) {
                lcaIndex = i;
            } else {
                break;
            }
        }
        System.out.println( " lca " + lcaIndex);

        if(lcaIndex != -1) {
            int d1 = p1.size() - lcaIndex - 1;
            int d2 = p2.size() - lcaIndex - 1;
             System.out.println( " d1 " + d1 + " d2 " + d2);
            ans = d1 + d2;
        }
        System.out.println( " ans " + ans);


        return ans;

    }

    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(8);
        root.left.right.right.right = new Node(9);
        System.out.println(minDistance(root, root.right  ,  root.left.right.right ));
        System.out.println("hello world");

    }
}
