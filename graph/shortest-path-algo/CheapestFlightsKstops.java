import java.util.*;
public class CheapestFlightsKstops{
    //some solution explained bellford as well -> gotta try that as well
    //dijktra problems
     public int findCheapestPrice(int n, int[][] fl, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }


        for(int i = 0; i<fl.length; i++){
            int[] f = fl[i];

            adj.get(f[0]).add(new int[]{f[1], f[2]});
        }

        int[] val = new int[n];
        Arrays.fill(val, Integer.MAX_VALUE);
        val[src] = 0;

        int ans =  Integer.MAX_VALUE;


        Queue<int[]> pq = new LinkedList<>();
        //node, cost, count
        pq.add(new int[]{src, 0, 0});

        while(!pq.isEmpty()) { 
            int[] p = pq.poll();
            int node = p[0], cost = p[1], count = p[2];

            // val[node] = cost;

            // System.out.println("poll " + node +  " "+ cost + " " + count);

            List<int[]> neigh = adj.get(node);

            for(int[] edge : neigh){
                int v = edge[0];
                int c = edge[1];

                //is neigh the dest
                if(count<=k){
                    if(v==dst){
                        // ans = Math.min(ans, cost+c); 
                        val[v] = Math.min(val[v], cost+c);
                    }//whenever dest appear we update ans
                    else {
                        if(val[v] > cost+c){ 
                            //since we want the cost to be minimum -> we only add min cost node
                            val[v] = cost+c;
                            pq.add(new int[]{v, cost+c, count+1});
                        }
                        
                    };
                }
            }
        }
        
        // System.out.println(Arrays.toString(val) + val[dst]);

        // if(ans == Integer.MAX_VALUE) return -1;
        // return ans;

        if(val[dst] == Integer.MAX_VALUE) return -1;
        return val[dst];
    }
}