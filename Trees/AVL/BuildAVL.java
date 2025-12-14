public class BuildAVL {
    static class Node{
        int data, height;
        Node left, right;

        Node(int data){
            this.data = data;
            height = 1;
            this.left = null;
            this.right = null;
        }
    }

    public static Node root;

    public static int height(Node root){
        while(root == null) return 0;

        return root.height;
    }

    //insert node
    public static Node insert(Node root, int data){
        if(root == null){
            return new Node(data);
        }

        if(root.data>data){
            root.left = insert(root.left, data);
        } else if(root.data<data){
            root.right = insert(root.right, data);
        } else {
            return root; //no duplicates allwoed
        }

        //height update for the root
        root.height = 1 + Math.max(height(root.left), height(root.right));

        //if balfac !=  -1 1 0, balance it and update height again
        int bf = balance(root);

        //rotation cases
        //ll
        if(bf>1 && data<root.left.data){
            return rightRotate(root)
        }
        //lr
        if(bf>1 && data>root.left.data){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        //rr
        if(bf<-1 && data>root.right.data){
            return leftRotate(root)
        }
        //rl
        if(bf<-1 && data<root.right.data){
            root.right =  rightRotate(root.right);
            return leftRotate(root);
        }

        return root; //means alredy balanced
    }

    public static Node rightRotate(Node y){
        Node x = y.left;
        Node T2 = x.right;
        // rotation using 3 nodes
        x.right=y;
        y.left=T2;
        // update heights
        y.height=Math.max(height(y.left),height(y.right))+1;x.height=Math.max(height(x.left),height(x.right))+1;
        // x is new root
        return x;
    }

    //balance fac the node
    public static int balance(Node root){
        if(root == null) return 0;

        return height(root.left) - height(root.right);

    }
}
