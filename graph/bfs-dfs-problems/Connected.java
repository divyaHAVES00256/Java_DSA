import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Connected {
    //using bfs
    public static int countComponents(int v, List<List<Integer>> adj){
        int componenets = 0;
        boolean chk[] = new boolean[v]; //check visited nodes

        int i = 0;
        while(i<v){
            // if not visited -> check the whole graph using bfs
            
            if(!chk[i]){
                ArrayList<Integer> island = new ArrayList<>();
                componenets ++;
                
                //here we are analying the whole isolated graph assuming it to be connected
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                // System.out.println(" node " + i);

                while(!q.isEmpty()){
                    int curr = q.poll();
                    chk[curr] = true;
                    island.add(curr);

                    for(int n : adj.get(curr)){
                        if(!chk[n]){
                            q.add(n);
                            chk[n] = true;
                        }
                    }
                    // int rem = q.poll();
                    // if(!chk[rem]){
                    //     island.add(rem);
                    //     chk[rem] = true;

                    //     //neighbours of rem
                    //     List<Integer> n = adj.get(rem);
                    //     for(int j = 0; j<n.size(); j++){
                    //         if(!chk[n.get(j)]){
                    //             q.add(n.get(j));
                    //         }
                    //     }
                    // }
                }
                System.out.println(" islands: " + island);
            }
            
            i++;
        }

        return componenets;
    }

    //using dfs
    public static void dfs(int v, List<List<Integer>> adj, boolean[] visited, ArrayList<Integer> ans){
        //mark curr true
        visited[v] = true;
        ans.add(v);

        //chcek neigbhours
        for(int i : adj.get(v)){
            if(!visited[i]){
                dfs(i, adj, visited, ans);
            }
            
        }

    }
    public static int components(int v, List<List<Integer>> adj){
       boolean visited[] = new boolean[v];
        int count = 0;
        for(int i = 0; i<v; i++){
            if(!visited[i]){
                ArrayList<Integer> island = new ArrayList<>();
                count++;
                dfs(i, adj, visited, island); 
                System.out.println(island);
            }
        }

        return count;
    }
     public static void main(String[] args) {

        // List of undirected edges
        // int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        int[][] edges = {{0, 5}, {2, 5}, {5, 0}};


        //1 create adjacancy list
        int v = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<v; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<edges.length; i++){
            int[] edge = edges[i];
            
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); //need to be undirected to calculte connected componnets
        }
        System.out.println(adj);

        // Print the number of connected components
        //using bfs
        System.out.println("Number of Connected Components: " + countComponents(v, adj));


        //using dfs
        System.out.println("Number of Connected Components: " + components(v, adj));

    }
}
