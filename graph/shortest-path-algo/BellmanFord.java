import java.util.*;

public class BellmanFord {

    static class Edge {
        int u, v, wt;

        Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    static void bellmanFord(int src, int n, ArrayList<Edge> edges, int[] dis) {

        // Relax all edges n - 1 times
        for (int i = 1; i < n; i++) {

            for (Edge e : edges) {
                int u = e.u;
                int v = e.v;
                int w = e.wt;

                if (dis[u] != Integer.MAX_VALUE && dis[u] + w < dis[v]) {
                    dis[v] = dis[u] + w;
                }
            }
        }

        // Detect negative cycle
        boolean hasCycle = false;

        for (Edge e : edges) {
            int u = e.u;
            int v = e.v;
            int w = e.wt;

            if (dis[u] != Integer.MAX_VALUE && dis[u] + w < dis[v]) {
                hasCycle = true;
                break;
            }
        }

        System.out.println("Negative cycle present: " + hasCycle);
    }

    public static void main(String[] args) {
        int n = 6;
        ArrayList<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 5));
        edges.add(new Edge(1, 2, -2));
        edges.add(new Edge(1, 5, -3));
        edges.add(new Edge(5, 3, 1));
        edges.add(new Edge(3, 2, 6));
        edges.add(new Edge(2, 4, 3));
        edges.add(new Edge(3, 4, -2));

        // Extra edge to create negative cycle
        // edges.add(new Edge(2, 1, -4));

        int src = 0;

        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;

        bellmanFord(src, n, edges, dis);

        System.out.println(Arrays.toString(dis));
    }
}