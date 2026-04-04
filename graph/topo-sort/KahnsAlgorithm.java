import java.util.*;
public class KahnsAlgorithm {
    //topo sort using bfs
    public static ArrayList<Integer> topologicalSort(int n, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        
        //indegree of each index
        int[] indegree = new int[n];
        for(int i = 0; i<n; i++){
            ArrayList<Integer> arr = adj.get(i);
            // System.out.println(arr);
            for(int v : arr){
                indegree[v]++;
            }
            // System.out.println(Arrays.toString(indegree));
        }

        //add indegree==0 in the queue intitially
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i  = 0; i<n; i++){
            if(indegree[i] == 0) q.add(i);
        }

        //toposort
        while(!q.isEmpty()){
            //poll the node
            int i = q.poll();

            //add in the ans
            ans.add(i);

            //check polls neighbour 
            ArrayList<Integer> ne = adj.get(i);

            //decrement the neighbours indegree, if it becomes 0 add in the queue
            for(int j : ne){
                indegree[j]--;
                if(indegree[j] == 0) q.add(j);
                System.out.println(j + "  " + i);
            }
            System.out.println(ans);
        }
        return ans;
        
    }
    public static void main(String[] args){
        // Number of vertices
        int V = 6;

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new java.util.ArrayList<>());
        }

        // Adding edges
        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        // Call the function to get topological sort
        ArrayList<Integer> ans= topologicalSort(V, adj);
        System.out.println(ans);

    
    }
}
