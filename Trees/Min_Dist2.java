import java.util.*;

public class Min_Dist2 {
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
    static Node lca(Node root, Node n1, Node n2) {
        ArrayList<Node> p1 = new ArrayList<>();
        ArrayList<Node> p2 = new ArrayList<>();

        boolean path1 = path(root, n1, p1);
        boolean path2 = path(root, n2, p2);

        if(path1 == false || path2 == false){
            return null;
        }

        Node lca = null;

        for(int i = 0; i < p1.size() && i < p2.size(); i++) {
            if(p1.get(i) == p2.get(i)) {
                lca = p1.get(i);
            } else {
                break;
            }
        }
        return lca;

    }
    public static int mindis(Node node, Node n){
        if(node == null){ //null
            return -1;
        }
        if(node == n){//node found
            return 0;
        }

        if(mindis(node.left, n)==-1 && mindis(node.right, n)==-1){//node is not found
            return -1;
        } else if(mindis(node.left, n) == -1){ //not in left tree
            return mindis(node.right, n)+1;
        } else {
            return mindis(node.left, n)+1;
        }
    }
    public static int mindistance2(Node root, Node n1, Node n2){
        Node lca = lca(root, n1, n2);

        return  mindis(lca, n1) +  mindis(lca, n2);
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(8);
        root.left.right.right.right = new Node(9);
        System.out.println(mindistance2(root, root.left.right,  root.left.right.right.right));
        System.out.println("hello world");

    }
}

