import java.util.ArrayList;
import java.util.List;

public class AdjacencyList {
    //1. Adjacency Matrix for Undirected and Unweighted
    // static void displayAdjList(List<List<Integer>> adj) {
    //     for (int i = 0; i < adj.size(); i++) {
    //         System.out.print(i + ": ");
    //         for (int j : adj.get(i)) {
    //             System.out.print(j + " ");
    //         }
    //         System.out.println();
    //     }
    // }
    public static void add_edge_UU(List<List<Integer>> adj, int i, int j){
        adj.get(i).add(j);
        adj.get(j).add(i);
    }

    //2. Adjacency list for directed and weighted
    public static void displayAdjList(List<int[]> []adj) {
        for (int i = 0; i < adj.length; i++) {
            System.out.print(i + " -> ");
            for (int[] edge : adj[i]) {
                System.out.print("(" + edge[0] + ", " + edge[1] + ") ");
            }
            System.out.println();
        }
    }
    public static void add_edge_DW(List<int[]>[] adj, int i, int j, int weight){
        adj[i].add(new int[]{j, weight});
    }

    

    public static void main(String[] args) {
        //1. Adjacency Matrix for Undirected and Unweighted
        // int v = 4;
        // List<List<Integer>> adj = new ArrayList<>();
        // for(int i = 0; i<4; i++){
        //     adj.add(new ArrayList<>());
        // }
        // add_edge_UU(adj, 0, 1);
        // add_edge_UU(adj, 1, 2);
        // add_edge_UU(adj, 1, 3);
        // add_edge_UU(adj, 2, 3);
        // displayAdjList(adj);

        //2. Adjacency list for directed and weighted
        ArrayList<int[]> []adj = new ArrayList[4];
        for(int i = 0; i<4; i++){
            adj[i] = new ArrayList<int[]>();
        }
        add_edge_DW(adj, 0, 1, 4);
        add_edge_DW(adj, 1, 2, 3);
        add_edge_DW(adj, 1, 3, 2);
        add_edge_DW(adj, 2, 3, -1);
        displayAdjList(adj);


    }
}
