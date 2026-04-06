import java.util.ArrayList;
import java.util.Stack;


public class TopoSort{
    public static void dfs(int i, boolean vis[], Stack<Integer> s, ArrayList<ArrayList<Integer>> adj) {
        vis[i] = true;

        ArrayList<Integer> n = adj.get(i);
        for(int j : n){
            if(!vis[j]) {
                // System.out.println(s);

                dfs(j, vis, s, adj);
            }
        }
        s.add(i);
        // System.out.println(s);
        // System.out.println(i);
    }
    public static ArrayList<Integer> topoSort(int v, ArrayList<ArrayList<Integer>> adj){
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[v];

        for(int i = 0; i<v; i++){
            if(!vis[i]){
                dfs(i, vis, st, adj);
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();

        while(!st.isEmpty()){
            arr.add(st.pop());
        }

        return arr;
    }

    public static void main(String[] args) {
         // Number of vertices
        int V = 6;

        // Create adjacency list for the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges
        // Adding edges
        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        // Get the topological order
        ArrayList<Integer> res = topoSort(V, adj);

        // Print result
        System.out.print("Topological Sort: ");
        for (int node : res) {
            System.out.print(node + " ");
        }

        // topoSort(V, adj);
    }
}