import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetectionDirected {
    //its a directed graph question using path based stack
    //similar too dfs based topo
    //tc = v+e
    public boolean canFinish1(int n, int[][] p) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i[] : p){
            adj.get(i[1]).add(i[0]);
        }


        boolean vis[] = new boolean[n];
        boolean path[] = new boolean[n]; // the path-visited keeps a track of visited nodes in the current traversal only

        for(int i = 0; i<n; i++){
            if(!vis[i]){
                boolean chk = dfs(i, vis, path, adj);

                if(chk) return false;
            }
           
        }

        return true;
    }

    public boolean dfs(int i, boolean vis[], boolean path[], List<List<Integer>> adj) {
        System.out.println(i);

        vis[i] = true;
        path[i] = true;

        List<Integer> neigh = adj.get(i);
     
        for(int j = 0; j<neigh.size(); j++) {
            if(path[neigh.get(j)]) {
                // System.out.println(Arrays.toString(path) + " path " + neigh.get(j));
                return true;
            }
            if(!vis[neigh.get(j)]){
                // System.out.println(Arrays.toString(vis) + " vis " + neigh.get(j));
                if(dfs(neigh.get(j), vis, path, adj)) return true;
                
            }
        }
        // System.out.println(i + " i " )  ;

        path[i] = false; //backtrack and turn them false in the path for the current traverse only

        return false;
    }

    //its a directed graph question -> topo sort
    //kahns algo -> bfs based topo
    //tc v+e
    public boolean canFinish(int n, int[][] p) {
        //1 form adj list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i[] : p){
            adj.get(i[1]).add(i[0]);
        }
        System.out.println(adj);

        Queue<Integer> q = new LinkedList<>();
        int[] deg = new int[n];

        for(int i  = 0; i<n ;i++){
            List<Integer> nb = adj.get(i);
            for(int j : nb) deg[j]++;
        }
        int count=0;
        for(int i = 0; i<n; i++) {
            if(deg[i]==0){ 
                q.add(i);
                count++;
            }
        }
        if(count<=0) return false;
        int idx = 0;
        // System.out.println(Arrays.toString(deg));
        while(!q.isEmpty()){
            int i = q.poll();
            idx++;
            // if(idx>n) return false;

            List<Integer> nb = adj.get(i);
            for(int j : nb){
                deg[j]--;
                if(deg[j] == 0) q.add(j);
            }

            // System.out.println(idx);
        }
        // return true;
        return idx == n;
    }

    // '''
    // 0 → 1 → 2 → 3
    //          ↑   |
    //          └───┘   (cycle between 2 and 3)
    // deg = [0, 1, 2, 1]

    // for this exmaple:
    // 0th added
    // 0th neighbors-> 1 added(its deg = 0)(here q does not have any element, it then go to its neighbour)
    // 1st neighbours-> 2 its deg is reduced to 1 but not added in the queue
    // now queue is empty 
    // but we still have to eplored 2 and 3 
    // hence rather than returning true at the end we return using how many nodes were explored
    // '''
}
