import java.util.*;
public class DAG_Topo_Shortest_Path {
    //given dag, weigted graph

    //brute force-> check all possible path -> using dfs
    //it only works for dag+no negative edges
    static class Pair{
        int n;
        int dis;

        Pair(int n, int dis){
            this.n = n;
            this.dis = dis;
        }
    }
    public static void path(int src, int dis, List<List<Pair>> adj, int[] ans){
        ans[src] = Math.min(ans[src], dis);
        List<Pair> arr = adj.get(src);
        for(Pair p : arr){
            //if node dis is more if we calculate using diff path -> then we do not need that path
            //it helps in reducing visiting same node twice
            if(p.dis+dis < ans[p.n]){
                path(p.n, p.dis+dis, adj, ans);
            }
        }
    }


    //using topo sort
    //(why? we are doing path relaxation -> imagine ts = a b c then it is for sure that a and b would have been alaready analyzed before reaching c)
    
    //tc = e+n
    //sc = n+n (st, vis)
    public static void topo(int node, boolean[] vis, List<List<Pair>> adj, Stack<Integer> st){
        vis[node] = true;

        List<Pair> arr = adj.get(node);
        for(Pair  p : arr){
            if(!vis[p.n]) topo(p.n, vis, adj, st);
        }

        st.push(node);
    }

    //total complexity
    //tc = topo + n + e
    //sc = topo + n+e(adj)
    public static void pathway(int src, List<List<Pair>> adj, int[] ans){
        //Step 1 :  form topo sort
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[adj.size()];
        for(int  i = 0; i<adj.size(); i++){
            if(!vis[i]) topo(i, vis, adj, st);
        }

        //Step 2 : 
        //a) add src as 0 in the ans
        ans[src] = 0;

        //b) pop till you reach src -> beacuse it may b possible that src is in the middle of the stack
        //we pop it because  whatever happens
        while(!st.isEmpty() && st.peek() != src) st.pop(); //n

        while(!st.isEmpty()) { //n+e
            int node = st.pop();   

            //c) update wieghts of neighbours of node
            List<Pair> arr = adj.get(node);

            for(Pair p : arr){
                //initial value of ans has max value in it
                //min of curr dis of p in ans, n dis plus prev(node) ans
                ans[p.n] = Math.min(ans[p.n], ans[node]+p.dis);
            }   
        }
    }


    public static void main(String[] args) {
        // Number of vertices
        int V = 7;

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

        adj.get(6).add(new Pair(4, 2));
        adj.get(6).add(new Pair(5, 3));
        adj.get(5).add(new Pair(4, 1));
        adj.get(4).add(new Pair(0, 3));
        adj.get(4).add(new Pair(2, 1));
        adj.get(0).add(new Pair(1, 2));
        adj.get(1).add(new Pair(3, 1));
        adj.get(2).add(new Pair(3, 3));

        int[] ans = new int[adj.size()];
        Arrays.fill(ans, Integer.MAX_VALUE);
        
        // path(0, 0, adj, ans);
        pathway(6, adj, ans);
        System.out.println(Arrays.toString(ans));
    }


   
}
