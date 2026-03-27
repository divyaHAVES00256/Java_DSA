import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

import java.util.Arrays;;

public class CycleDetectionUndirected {
    public static boolean dfs(int curr, int par, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[curr] = true;

        ArrayList<Integer> n = adj.get(curr);
        for(int i = 0; i<n.size(); i++){
            //node not viiisted simply run dfs
            //if the cycle found midway return true and stop futher exploration
            if(!vis[n.get(i)]) {
                if( dfs(n.get(i), curr, vis, adj) ) return true;
            }

            //if it is visted and neigh is not the parent -> cycle detcted
            else if (n.get(i)!=par) return true;
           
        }
        //we searched that whole neigbhout of the particular path 
        //but could not find the cycle
        return false;
    }
    public static boolean hascycledfs(int v,  ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[v];
        for(int i = 0; i<adj.size(); i++){
            if(!vis[i]){
                boolean ans = dfs(i, -1, vis, adj);
                if(ans) return true;
            }
        }
        return false;
    }


    public static boolean hascyclebfs(int v,  ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[v];
       
        int [] parent = new int[v];
        Arrays.fill(parent, -1);

        for(int i = 0; i<v; i++){
            // System.out.println(Arrays.toString(parent) + " hello " + i);

            if(!vis[i]) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                vis[i] = true;

                while(!q.isEmpty()){
                    int rem = q.poll();
                    
                    
                    ArrayList<Integer> n = adj.get(rem);
                    for(int j  = 0; j<n.size(); j++){
                        //if not visited add and mark it true : normal
                        if(!vis[n.get(j)]){
                            vis[n.get(j)] = true;
                            parent[n.get(j)] = rem;
                            q.add(n.get(j));
                        } else if( n.get(j) != parent[rem]){
                            //if neigh is already visited plus not a parent of rem
                            //detect cycle
                             return true;
                        }   
                        
                    }
                    System.out.println(Arrays.toString(parent));

                }
            }
        }

        return false;
    }

    //this code is same a smine but we created node to store parent alongwise the node in the queue
    static class Node {
        int first; //node
        int second; //parent
        public Node(int first, int second) {
            this.first = first;
            this.second = second; 
        }
    }
    static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s, boolean vis[], int parent[]){
       Queue<Node> q =  new LinkedList<>(); //BFS
       q.add(new Node(s, -1));
       vis[s] = true;
       
       // until the queue is empty
       while(!q.isEmpty()){
           // source node and its parent node
           int node = q.peek().first;
           int par = q.peek().second;
           q.remove(); 
           
           // go to all the adjacent nodes
           for(Integer it: adj.get(node)){
               if(!vis[it])  {
                   q.add(new Node(it, node));
                   vis[it] = true; 
               }
        
                // if adjacent node is visited and is not its own parent node
               else if(par != it) return true;
           }
       }
       
       return false;
    }
    
    // function to detect cycle in an undirected graph
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        boolean vis[] = new boolean[V];
        Arrays.fill(vis,false);
        int parent[] = new int[V];
        Arrays.fill(parent,-1);  
        
        for(int i=0;i<V;i++)
            if(!vis[i]) 
                if(checkForCycle(adj, i,vis, parent)) 
                    return true;
    
        return false;
    }
    public static void main(String[] args){
        // Example: Graph with 5 nodes and a cycle
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Add edges
        // adj.get(0).add(1);
        // adj.get(1).add(0);
        // adj.get(1).add(2);
        // adj.get(2).add(1);
        // adj.get(2).add(3);
        // adj.get(3).add(2);
        // adj.get(3).add(4);
        // adj.get(4).add(3);
        // adj.get(4).add(1);

        
        // adj.get(0).add(1);
        // adj.get(1).add(0);
        // adj.get(1).add(2);
        // adj.get(2).add(1);

        adj.get(1).add(2); adj.get(2).add(1);
        // adj.get(1).add(3); adj.get(3).add(1);
        // adj.get(2).add(3); adj.get(3).add(2);

        boolean ans = isCycle(4, adj);
        if (ans)
            System.out.println("1");    
        else
            System.out.println("0");

        // System.out.println(hascyclebfs(V, adj));
    }
}
