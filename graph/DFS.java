import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class DFS {
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int from, int to) {
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

    //graph is disconnected
    public static void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> ans){
        //mark curr true
        visited[v] = true;
        ans.add(v);
        // System.out.println(v + " mark ");


        //neighbours of the current
        for(int i : adj.get(v)){
            // System.out.println(i + " s ");
            if(!visited[i]){
                // System.out.println(i + " neigh ");
                // visited[i] = true; //adding it is reductand cuz recursivly outer visted will aslo do the same
                // ans.add(v); //adding it will be add reduandatnt node
                dfs(i, adj, visited, ans);
            }
            
        }

    }

    public static void disconnected(int v, ArrayList<ArrayList<Integer>> adj){
       boolean visited[] = new boolean[v];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i<v; i++){
            if(!visited[i]){
                dfs(i, adj, visited, ans); 
               
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int V = 10;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

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

        // Edges from the given graph
        // addEdge(adj,0, 1);
        // addEdge(adj,0, 2);
        // addEdge(adj,1, 3);
        // addEdge(adj,2, 4);
        // addEdge(adj,3, 4);
        // addEdge(adj,3, 5);
        // addEdge(adj,4, 5);
        // addEdge(adj,5, 6);
        
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 4, 5);
        addEdge(adj, 4, 6);

        addEdge(adj, 9, 8);
        addEdge(adj, 8, 9);

        

        display(adj);

        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[V];

        dfs(1, adj, visited, ans);
        System.out.println(ans);

        System.out.println("dissconnected");
        disconnected(V, adj);
    }
}
