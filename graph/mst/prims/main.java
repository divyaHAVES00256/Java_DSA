import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class main {
    //greedy(min heap -> gets min cost edge) + bfs
    //time : (n+e)loge
    //space : (n+e)
    public int spanningTree(int v, int[][] edges) {
        //pq sorted on edge weights
        //wt, node, par
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        
        //graph
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i<v; i++){
            List<int[]> list = new ArrayList<>();
            adj.add(list);
        }
        for(int i[] : edges){
            int u = i[0];
            int x = i[1];
            int w = i[2];
            
            adj.get(x).add(new int[]{u, w});
            adj.get(u).add(new int[]{x, w});
        }
        
        //visisted array
        //node
        boolean[] vis = new boolean[v];
        
        //contains mst edges
        ArrayList<int[]> ans = new ArrayList<>();
        
        pq.add(new int[]{0, 0, -1});
        
        //min cost
        int sum = 0;
        
        while(!pq.isEmpty()){
            //current min node
            int[] curr = pq.remove();
            
            //if it is visted -> edge is already been counted in the mst
            if(vis[curr[1]]) continue;
            
            //add current min wieght
            sum+=curr[0];
            vis[curr[1]] = true;
            
            if(curr[2]!=-1) {
                int[] edge = new int[2];
                
                edge[0] = curr[1];
                edge[1] = curr[2];
                
                ans.add(edge);
            }
            
            List<int[]> child = adj.get(curr[1]);
            for(int i = 0; i<child.size(); i++){
                if(!vis[child.get(i)[0]]){
                    int wt = child.get(i)[1];
                    int node = child.get(i)[0];
                    int par = curr[1];
                    pq.add(new int[]{wt, node, par});
                }
            }
            
        }
        
        ans.forEach(arr -> System.out.println(Arrays.toString(arr)));
        
        return sum;
        
    }
}
