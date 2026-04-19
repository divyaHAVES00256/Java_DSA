// import java.lang.LiveStackFrame.PrimitiveSlot;
import java.util.*;
//graph ust not have any negative weghts or negative cycles, 
//used for wieghted graphs
public class Dijkstra {
    static class Pair{
        int node;
        int dis;

        Pair(int node, int dis){
            this.node = node;
            this.dis = dis;
        }
    }

    //tc = v(fill ans) + elogv
    //mc = e+v + v
    public static void path(int src, List<List<Pair>> adj){
        //1 Intialize queue -> stores shortest dis 
        //it contains -> dis after updation
        PriorityQueue<Pair> pq = new PriorityQueue<>( //stores all edges(n+e)
            (a, b) -> {
                if(a.dis == b.dis) return Integer.compare(a.node, b.node);
                return Integer.compare(a.dis, b.dis);
            }
        );
        //2 Intialize ans
        int[] ans = new int[adj.size()]; //v
        Arrays.fill(ans, Integer.MAX_VALUE); //run till v

        ans[src] = 0; //src must have shortest dis 0

        //3 Store pair in the queue only which when we ecounter shorter dis
        pq.add(new Pair(src, 0));
        
        while(!pq.isEmpty()){ //v
            //a :  poll shortest (top) from the top
            Pair p = pq.poll(); //sort log(v^2)
            System.out.println(p.node);
            //b Skip outdated entries
            if (p.dis > ans[p.node]) continue; 
            
            //c :  check neigbours of p and add those pair which is shorter from already filled distance in the ans
            List<Pair> arr = adj.get(p.node); 
            for(Pair n : arr){ //v-1
                //updated dis is less than what is present in the ans
                int newDist = p.dis + n.dis;
                if(newDist < ans[n.node]) {
                    pq.add(new Pair(n.node, newDist)); //sort log(v^2)
                    ans[n.node] = newDist;
                }
            }
        }

        System.out.println(Arrays.toString(ans));
    }


    public static void main(String[] args) {
        // Number of vertices
        int V = 6  ;

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
        path(0, adj);
        
    }

}
