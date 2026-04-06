import java.sql.Time;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix_01 {
    //tc n*m(intialization) + n*m*4(queue)
    // Space Complexity: O(N x M) + O(N x M) + O(N x M) ~ O(N x M), for the visited array, distance matrix, and queue space takes up N x M locations at max.
    //algorithm
    // '''
    //     1) dis(all infity) and vis 2d array intialization
    //     2) quque with pair (ideces, current smallest dis)
    //     3) in the queue intialize it with adding all the 0s and dis = 0 
    //     4) run loop while queue is not emepty
    //         a) cuurent poll
    //         b) mark vis
    //         c) dis = min(dis, poll value)
    //         d) add chilered of poll in the queue with dis = poll value+1

    // this code chcek its negigbours like bfs and whoever is the smallest, it assign it avalue to it
    // '''
    class Pair {
        int[] arr;
        int value;

        Pair(int[] arr, int value) {
            this.arr = arr;
            this.value = value;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int dis[][] = new int[mat.length][mat[0].length];
        for (int i = 0; i < dis.length; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }

        int vis[][] = new int[mat.length][mat[0].length];
        Queue<Pair> q = new LinkedList<>();
        
        //1 initializing by adding all '0' in the que with distance 0
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n ; j++){
                if(mat[i][j] == 0) {
                    int[] pair = {i, j};
                    q.add(new Pair(pair, 0));
                    // vis[i][j] == 1; //if we mark 0 vis intiallly then number of checkups will reduce leads to decreasing in tc
                }
            }
        }


        //2 basically we are starting from all the '0' s
        //and store its childer incrementing the dis from it using bfs
        while(!q.isEmpty()){
            Pair p = q.poll();
            int[] idx = p.arr;
            int i = idx[0], j = idx[1];
            int val = p.value;

            //3 add val in the dis
            dis[i][j] = Math.min(val, dis[i][j]);
            System.out.println(Arrays.toString(idx) + " " + val);

            //4 since intially we have marked all 0's visited we are only checking unvsisited 1s and its neigh
            if(vis[i][j] == 0){
                //mark visisted
                vis[i][j] = 1;

                //add its univisited chilred t the queue mark it vis
                //left
                if(j+1 < n && vis[i][j+1]==0){
                    int pair[] = {i, j+1};
                    q.add(new Pair(pair, val+1));
                }

                //right
                if(j-1 >= 0 && vis[i][j-1]==0){
                    int pair[] = {i, j-1};
                    q.add(new Pair(pair, val+1));
                }

                //top
                if(i-1 >= 0 && vis[i-1][j]==0){
                    int pair[] = {i-1, j};
                    q.add(new Pair(pair, val+1));
                }

                //bottom
                if(i+1 < m && vis[i+1][j]==0){
                    int pair[] = {i+1, j};
                    q.add(new Pair(pair, val+1));
                }
            }

            // System.out.println(Arrays.deepToString(dis));
        }

        // System.out.println(Arrays.deepToString(dis));
        
        return dis;
    
    }



    // Time Complexity: O(NxM + NxMx4) ~ O(N x M), the BFS function will be called for (N x M) nodes, and for every node, we are traversing for 4 neighbors, so it will take O(N x M x 4) time.
    // Space Complexity: O(N x M) + O(N x M) + O(N x M) ~ O(N x M), for the visited array, distance matrix, and queue space takes up N x M locations at max.
    //algorithm
    // '''
    //     1. mark all 0s vis, add them in the queue while dis marking as 0
    //     2. while polling
    //         a) only add unviisted neigh and mark it vis with +1 dis from the polled one
    // '''
    
    public int[][] updateMatrix2(int[][] mat) {
        int n = mat.length;      
        int m = mat[0].length; 

        int[][] vis = new int[n][m];
        int dis[][] = new int[n][m];

        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m ; j++){
                if(mat[i][j] == 0) {
                    int[] pair = {i, j};
                    q.add(new Pair(pair, 0));
                    vis[i][j] = 1; //if we mark 0 vis intiallly then number of checkups will reduce leads to decreasing in tc
                }
            }
        }

         // Directions: Up, Right, Down, Left
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int idx[] = p.arr;
            int i = idx[0], j = idx[1];

            int val = p.value;

            dis[i][j] = val;

            //directions and unviisted neigh
            for(int d = 0; d<4; d++){
                int nr = i+delRow[d];
                int nc = j+delCol[d];

                //chevk the new cell is unvisited and in the bound(l r t b)
                if(nr<n && nr>=0 && nc<m && nc>=0 && vis[nr][nc] == 0){
                    vis[nr][nc] = 1;
                    int[] pair = {nr, nc};
                    q.add(new Pair(pair, val+1));
                }
            }

        }

        return dis;
    }
}
