import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

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

    static void bfs(ArrayList<ArrayList<Integer>> adj , int src){
        Queue<Integer> q = new LinkedList<>();
        boolean[] chk = new boolean[adj.size()];
        int[] ans = new int[adj.size()];
        
        q.add(src);
        int idx = 0;
        while(idx<adj.size()){
            int rem = q.remove(); //curr element
            
            if(!chk[rem]){
                ans[idx++] = rem;
                chk[rem] = true;

                ArrayList<Integer> n = adj.get(rem);
                for(int i = 0; i<n.size(); i++){
                    if(!chk[n.get(i)])q.add(n.get(i));
                }
                System.out.println("q : " +q);
            }
        }

        System.out.println("ans : " +Arrays.toString(ans));
    }

    public static void main(String[] args) {

        int V = 7;
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
        addEdge(adj,0, 1);
        addEdge(adj,0, 2);
        addEdge(adj,1, 3);
        addEdge(adj,2, 4);
        addEdge(adj,3, 4);
        addEdge(adj,3, 5);
        addEdge(adj,4, 5);
        addEdge(adj,5, 6);

        display(adj);
        bfs(adj, 0);
    }
}
