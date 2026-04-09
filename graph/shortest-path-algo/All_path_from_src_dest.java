import java.util.*;
public class All_path_from_src_dest{
    //givem graph is dag and directed
     //mc, tc = (number of paths) × (work per path) = O(paths * n)
    public static void dfs(int src, int des, List<List<Integer>> ans, List<Integer> step, int[][] graph, boolean vis[]){
        step.add(src);
        vis[src] = true;
        // System.out.println(" andd " + step +  " curr " + step.get(step.size()-1));
        if(step.get(step.size()-1)==des){
            ans.add(new ArrayList<>(step));
            // System.out.println(step + " ans " + ans);

        }

        int[] arr = graph[src];
        for(int i : arr){
            if(!vis[i]) dfs(i, des, ans, step, graph, vis);
            // dfs(i, des, ans, step, graph, vis);
        }
        // System.out.println(" rem " + step);

        vis[src] = false;
        step.remove(step.size()-1);
        
    }
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> step = new ArrayList<>();
        boolean vis[] = new boolean[graph.length];

        dfs(0, graph.length-1, ans, step, graph, vis);
        System.out.println(step + " ans " + ans);
        return ans;
    }
    public static void main(String[] args) {
        
    }
}