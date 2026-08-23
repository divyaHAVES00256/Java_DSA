import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class KruskalDsuByRank {
    static int kruskalsMST(int n, int[][] edges) {
        // code here
        // Collections.sort(matrix, Comparator.comparingInt(row -> row.get(col)));
        // Arrays.sort(matrix, Comparator.comparingInt(row -> row[col]));
        
        //sorting helps us to only consider the minimum path first
        Arrays.sort(edges, Comparator.comparingInt(r -> r[2]));
        
        dsu ds = new dsu(n);
        int ans = 0; //mst cost
        List<int[]> path = new ArrayList<>(); //mst paths
        
        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            
            int paru = ds.find(u);
            int parv = ds.find(v);
            
            if(paru!=parv){
                //if thier ultimal parents aare not equal they must not be connected
                //hence make connectiom
                path.add(new int[]{u, v});
                ans+=w;
                
                ds.union(u, v);
            }
        }
        
        // for(int i[] : path){
        //     System.out.println(Arrays.toString(i));
        // }
        
        return ans;
    }
}
class dsu {
    List<Integer> rank = new ArrayList<>(); 
    List<Integer> parent = new ArrayList<>();
    
    dsu(int n){
        for(int i = 0; i<n; i++){
            rank.add(0);
            parent.add(i);
        }
    }
    
    int find(int u){
        if(u == parent.get(u)) return u;
        
        parent.set(u, find(parent.get(u)));
        
        return parent.get(u);
    }
    
    void union(int u, int v){
        int paru = find(u);
        int parv = find(v);
        
        if(paru == parv) return;
        
        if(paru<parv){
            parent.set(paru, parv);
            // par[u] = parv;
        } else if(parv<paru){
            parent.set(parv, paru);
            // par[v] = par[u];
        } else {
            parent.set(paru, parv);
            rank.set(parv, rank.get(parv)+1);
        }
    }
}
