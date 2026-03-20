import java.util.ArrayList;
import java.util.List;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int from, int to) {
        //undirected unwiegted
        adj.get(from).add(to);
        adj.get(to).add(from);

    }

    static void display(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + " : ");
            for (int v : adj.get(i)) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    //wrong approach
    static void bfs(ArrayList<ArrayList<Integer>> adj , int src, int[] ans, int idx){
        Queue<Integer> q = new LinkedList<>();
        boolean[] chk = new boolean[adj.size()]; //it will reintialize the chk evrytime isolated graph comes, hence cause amnesia
        //also if there are many nodes, reintializing it will cause mle
        
        q.add(src);
       
        while(idx<adj.size() && !q.isEmpty()){
            int rem = q.remove(); //curr element
            
            if(!chk[rem]){
                ans[idx++] = rem;
                chk[rem] = true;

                //add neighbours of rem in the q
                ArrayList<Integer> n = adj.get(rem);
                for(int i = 0; i<n.size(); i++){
                    if(!chk[n.get(i)])q.add(n.get(i));
                }
                // System.out.println("q : " +q);
            }
        }
        if(idx<adj.size()){ //that means q is empty and we still have nodes left to explore
            bfs(adj, idx, ans, idx); //since index 0 represnts node 0, hence src will be idx
        }        
    }

    public static void bfs_disconnected(int v, ArrayList<ArrayList<Integer>> adj ){
        boolean chk[] = new boolean[v]; //check visited nodes
        ArrayList<Integer> ans = new ArrayList<>();
        int idx = 0;

        int i = 0;
        while(i<v){
            // if not visited -> check the whole graph using bfs
            if(!chk[i]){
                //here we are analying the whole isolated graph assuming it to be connected
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                chk[i] = true;

                while(!q.isEmpty()){
                    int curr = q.poll();
                    ans.add(curr);
                    for(int neigh : adj.get(curr)){
                        if(!chk[neigh]){
                            q.add(neigh);
                            chk[neigh] = true;  //using it we wont we analying sam element twice
                            // ans.add(neigh); //if you add here twice will be added beacuse outer addition is also adding the same poll
                        }
                    }
                }
            }
            
            i++;
        }
        System.out.println(" islands: " + (ans));
    }

    static void bfs_CONNECTED(ArrayList<ArrayList<Integer>> adj , int src){
        Queue<Integer> q = new LinkedList<>();
        boolean[] chk = new boolean[adj.size()];
        
        q.add(src);
        int[] ans = new int[adj.size()];
        int idx = 0;
       
        while(idx<adj.size() && !q.isEmpty()){
            int rem = q.remove(); //curr element
            
            if(!chk[rem]){
                ans[idx++] = rem;
                chk[rem] = true;

                //add neighbours of rem in the q
                ArrayList<Integer> n = adj.get(rem);
                for(int i = 0; i<n.size(); i++){
                    if(!chk[n.get(i)])q.add(n.get(i));
                }
                // System.out.println("q : " +q);
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = 7;
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        //connected graph
        // edges (directed, unweighted)
        // addEdge(adj, 0, 1);
        // addEdge(adj, 0, 2);
        // addEdge(adj, 1, 0);
        // addEdge(adj, 1, 2);
        // addEdge(adj, 2, 1);
        // addEdge(adj, 2, 0);
        // addEdge(adj, 2, 3);
        // addEdge(adj, 2, 4);
        // addEdge(adj, 3, 2);
        // addEdge(adj, 4, 2);

        //Disconnected graph into three componenets
        // Island 1
        addEdge(adj, 0, 2);
        addEdge(adj, 2, 1);
        addEdge(adj, 2, 3);

        // Island 2 (Node 3 is isolated - no edges added)

        // Island 3
        addEdge(adj, 5, 6);
        addEdge(adj, 6, 5); // Making this one a little loop


        display(adj);
        // int[] ans = new int[adj.size()];
        // int idx = 0;
        // bfs(adj, 0, ans, idx);
        // System.out.println("ans : " +Arrays.toString(ans));

        bfs_disconnected(v, adj);
    }
}
