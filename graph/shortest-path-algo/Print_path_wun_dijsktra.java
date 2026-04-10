import java.util.*;
public class Print_path_wun_dijsktra {
    static class Pair{
        int node;
        int dis;

        Pair(int node, int dis){
            this.node = node;
            this.dis = dis;
        }
    }
    //print path from src to dest in weighted, undirected graph using dijsktra
    //tc = dijkstra + v
    public static void path(List<List<Pair>> adj, int src, int dest){
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if(a.dis == b.dis){
                    return Integer.compare(a.node, b.node);
                }
                return Integer.compare(a.dis, b.dis);
            }
        );

        int[] ans = new int[adj.size()];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src] = 0;

        //for keeping track of the path, we simply track where i am coming from
        //memoization
        int[] parent = new int[adj.size()];
        for(int i = 0; i<parent.length; i++) parent[i] = i;

        pq.add(new Pair(src, 0));
        while(!pq.isEmpty()) {
            Pair p = pq.poll();

            if (p.dis > ans[p.node]) continue;

            List<Pair> neigh = adj.get(p.node);

            for(Pair n : neigh){
                int newDist = n.dis + p.dis;
                if(newDist < ans[n.node]){
                    ans[n.node] = newDist;  //update ans
                    parent[n.node] = p.node; //add parent for node

                    pq.add(new Pair(n.node, newDist));
                }
            }
        }

        ArrayList<Integer> shortest = new ArrayList<>();
        System.out.println(Arrays.toString(parent));

        while(parent[dest]!=dest) {
            shortest.add(0, dest);
            dest = parent[dest];
        }
        shortest.add(0, dest);
        System.out.println(shortest);
                    System.out.println(Arrays.toString(ans));
    }

    public static void main(String[] args) {
        // Number of vertices
        int V = 6 ;

        // Create adjacency list for the graph
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // adj.get(0).add(new Pair(1, 3));
        // adj.get(0).add(new Pair(2, 4));
        // adj.get(1).add(new Pair(2, 2));
        // adj.get(2).add(new Pair(3, 3));

        // adj.get(0).add(new Pair(1, 2));
        // adj.get(0).add(new Pair(2, 1));
        // adj.get(1).add(new Pair(3, 3));
        // adj.get(2).add(new Pair(3, 1));
        // adj.get(3).add(new Pair(4, 2));
        // adj.get(1).add(new Pair(4, 10));

        // adj.get(6).add(new Pair(4, 2));
        // adj.get(6).add(new Pair(5, 3));
        // adj.get(5).add(new Pair(4, 1));
        // adj.get(4).add(new Pair(0, 3));
        // adj.get(4).add(new Pair(2, 1));
        // adj.get(0).add(new Pair(1, 2));
        // adj.get(1).add(new Pair(3, 1));
        // adj.get(2).add(new Pair(3, 3));
        
        
        adj.get(0).add(new Pair(1, 4));
        adj.get(0).add(new Pair(2, 4));

        adj.get(1).add(new Pair(0, 4));
        adj.get(1).add(new Pair(2, 2));

        adj.get(2).add(new Pair(0, 4));
        adj.get(2).add(new Pair(1, 2));
        adj.get(2).add(new Pair(3, 3));
        adj.get(2).add(new Pair(4, 1));
        adj.get(2).add(new Pair(5, 6));

        adj.get(3).add(new Pair(2, 3));
        adj.get(3).add(new Pair(5, 2));

        adj.get(4).add(new Pair(2, 1));
        adj.get(4).add(new Pair(5, 3));

        adj.get(5).add(new Pair(2, 6));
        adj.get(5).add(new Pair(3, 2));
        adj.get(5).add(new Pair(4, 3));


        // adj.get(0).add(new Pair(1, 2));
        // adj.get(0).add(new Pair(3, 1));

        // adj.get(1).add(new Pair(0, 2));
        // adj.get(1).add(new Pair(4, 5));
        // adj.get(1).add(new Pair(2, 4));

        // adj.get(2).add(new Pair(1, 4));
        // adj.get(2).add(new Pair(4, 1));
        // adj.get(2).add(new Pair(3, 3));

        // adj.get(3).add(new Pair(0, 1));
        // adj.get(3).add(new Pair(2, 3));

        // adj.get(4).add(new Pair(1, 5));
        // adj.get(4).add(new Pair(2, 1));
        path(adj, 0, 4);
        
    }
}
