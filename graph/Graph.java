import java.util.ArrayList;
import java.util.List;
public class Graph {
    //using edge class
    static class Edge{
        int dest, weight;
        Edge(int d, int w){
            this.dest = d;
            this.weight = w;
        }
    }

    //adjacency list and vertices
    private List<List<Edge>> adj;
    private int v;

    //constructore
    Graph(int v){
        this.v = v;
        adj = new ArrayList<>();
        for(int i = 0; i<v; i++){
            adj.add(new ArrayList<>());
        }
    }
    // Add node
    public void addEdge(int u, int v, int weight){
        adj.get(u).add(new Edge(v, weight));
    }

     // Display graph
    public void display() {
        for (int i = 0; i < v; i++) {
            System.out.print(i + " -> ");
            for (Edge e : adj.get(i)) {
                System.out.print("(" + e.dest + ", " + e.weight + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Graph g = new Graph(4);

        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 2);
        g.addEdge(1, 2, 3);
        g.addEdge(2, 3, 4);

        g.display();
    }
}
