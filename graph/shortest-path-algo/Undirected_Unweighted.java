import java.util.*;

public class Undirected_Unweighted {
    // find the shortest path from source to every other node
    //tc = n+v(bfs) + v(create adj from edges) + n(add node in ans)
    // mc = n+v(adj) + n(queue) + n(vis) + n(ans)
    public static void path(int src, List<List<Integer>> adj){
        int[] ans = new int[adj.size()];
        Arrays.fill(ans, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[adj.size()];

        ans[0] = 0;
        q.add(0);
        vis[0] = true;
        while(!q.isEmpty()){
            int rem = q.poll();
            List<Integer> n = adj.get(rem);
            System.out.println(n + " "+ rem);

            for(int i : n){
                ans[i] = Math.min(ans[i], ans[rem]+1);
                if(!vis[i]) {
                    System.out.println(i + " i "+ rem);

                    q.add(i);
                    vis[i] = true; //true here so that we dont add same ele 
                }
            }
        }

        System.out.println(Arrays.toString(ans));
    }

    public static void main(String[] args) {
        // Number of vertices
        int V = 9;

        // Create adjacency list for the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // 0
        adj.get(0).add(1);
        adj.get(0).add(3);

        // 1
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(1).add(3);

        // 2
        adj.get(2).add(1);
        adj.get(2).add(6);

        // 3
        adj.get(3).add(0);
        adj.get(3).add(1);
        adj.get(3).add(4);

        // 4
        adj.get(4).add(3);
        adj.get(4).add(5);

        // 5
        adj.get(5).add(4);
        adj.get(5).add(6);

        // 6
        adj.get(6).add(2);
        adj.get(6).add(5);
        adj.get(6).add(7);
        adj.get(6).add(8);

        // 7
        adj.get(7).add(6);
        adj.get(7).add(8);

        // 8
        adj.get(8).add(6);
        adj.get(8).add(7);

        // Get the topological order
        path(0, adj);
    }
}
