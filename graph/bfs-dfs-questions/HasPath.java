import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class HasPath {
    //dfs
    public boolean dfs(int src, int dest, List<List<Integer>> adj, boolean visited[]){
        if(src == dest) {
            return true;
        }
        visited[src] = true;
        for(int i : adj.get(src)){
            if(!visited[i]){
                boolean res = dfs(i, dest, adj, visited);
                if(res == true) return true;
            }
        }

        return false; //evrytime neigbhour reaches dead end, it returns false
    }
    public boolean validPathDfs(int n, int[][] edges, int source, int destination) {
        //rather than checking the whole graph, start directly by sourcea and seacrch the graph only
        if(n==1) return true;
        //form a graph
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<edges.length; i++){
            int[] edge = edges[i];
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); 
        }

        boolean visited[] = new boolean[n];
        boolean dest = dfs(source, destination, adj, visited);

        return dest;
    }


    //bfs
    public boolean validPathBfs(int n, int[][] edges, int source, int destination) {
        //rather than checking the whole graph, start directly by sourcea and seacrch the graph only
        if(n==1) return true;
        //form a graph
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<edges.length; i++){
            int[] edge = edges[i];
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); 
        }

        boolean visited[] = new boolean[n];
        visited[source] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(source);

        while(!q.isEmpty()) {
            int rem = q.poll();
            if(rem == destination) return true;

            for(int i : adj.get(rem)){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                    if(i == destination) return true;
                }
            }
        }

        return false;
    }

}
