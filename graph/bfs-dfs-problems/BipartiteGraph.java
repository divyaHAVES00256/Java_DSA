import java.util.Arrays;

public class BipartiteGraph {
    //tc=(V+2E)  
    //it is similar to keeping track of the parents  like we did in dfscycledetcetionundir
    public boolean ispossible(int curr, int prev, boolean[] chk, int[] color, int[][] graph){
        //runs total chk length-> V
        chk[curr] = true; //2 mark current node true
       
        color[curr] = -color[prev]; //3 mark current node diffrent from prev(previous node is basically current's parent)

        int[] n = graph[curr]; //dfs
        for(int i : n){
            if(!chk[i]){ 
                //4a if node not visited -> run normally
                //a any point if it returs false, stop the dfs and return false
                boolean ans = ispossible(i, curr, chk, color, graph);
                if(!ans) return false;
            } else {
                //4b if neighbour of current is visted and is same color as curr then it is not bipartite
                if(color[i] == color[curr]) return false;
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        boolean chk[] = new boolean[graph.length];
        int color[] = new int[graph.length];
        Arrays.fill(color, 1); //intialize with 1 (we are colring 1 and -1)
        
        for(int i = 0; i<graph.length; i++){ // each edge is traversed twice-ie for each node -> 2E
            if(!chk[i]){
                //1 if any point we found false, return it
                //initailly the prev and current will be same
                boolean ans = ispossible(i, i, chk, color, graph);
                if(!ans) return false;
            }
        }

        return true;
    }
}
