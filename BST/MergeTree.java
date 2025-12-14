import java.util.ArrayList;

import javax.swing.tree.TreeNode;

public class MergeTree {
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

    //sorted array to bst
    static Node arraytobst(ArrayList<Integer> nums, int l, int r){
        if(l>r) {  return null;}
        int mid = l+(r-l)/2;

        Node root = new Node(nums.get(mid));

        root.left=arraytobst(nums, l, mid-1);
        root.right=arraytobst(nums, mid+1, r);

        return root;
    }

    static void inorder(Node node, ArrayList<Integer> ar){
        if(node == null) return;
        inorder(node.left, ar);
        ar.add(node.data);
        inorder(node.right, ar);
    }

    public static Node mergbst(Node n1, Node n2){
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();


        inorder(n2, a2);
        inorder(n1, a1);
        
        int i = 0;
        int j = 0;

        while(i<a1.size() && j<a2.size()){
            if(a1.get(i)<a2.get(j)){
                ans.add(a1.get(i));
                i++;
            } else {
                ans.add(a2.get(j));
                j++;
            }
        }
        while(i<a1.size() ){
                ans.add(a1.get(i));
                i++;
        }
        while(j<a2.size()){
                ans.add(a2.get(j));
                j++;
        }

        return arraytobst(ans, 0, ans.size()-1);
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

        Node root1 = new Node(50);
        root1.left = new Node(30);
        root1.right = new Node(60);
        // root1.left.left = new Node(5);
        // root1.left.left.left = new Node(1);
        // root1.left.left.right = new Node(8);
        root1.left.right = new Node(35);   
        root1.right.left = new Node(45);
        root1.right.right = new Node(70);
        root1.right.right.left = new Node(65);
        root1.right.right.right = new Node(80);

        /*
                  50
                 /  \
               30    60
              / \    / \
             5  35  45  70
            1 8         / \
                      65   80
        */
        ArrayList<Integer> ans = new ArrayList<>();
        Node node = mergbst(root, root1);

        inorder(node, ans);
        System.out.println(ans);

    }
}
