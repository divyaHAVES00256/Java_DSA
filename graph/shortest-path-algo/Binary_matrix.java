import java.util.LinkedList;
import java.util.Queue;

public class Binary_matrix {
    //its a unweighted graph ->  bfs works the best
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]!=0 || grid[n-1][n-1]!=0) return -1;

        
      
        int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},
            {1, 1},
            {-1, -1},
            {-1, 1},
            {1, -1}
        };
        Queue<int[]> q = new LinkedList<>();

        // int INF = 1_000_000_000; // or Integer.MAX_VALUE / 2
        // int[][] path = new int[n][n];

        // for (int i = 0; i < n; i++) {
        //     Arrays.fill(path[i], INF);
        // }
        // path[0][0] = 1;

        int ans = Integer.MAX_VALUE;

        boolean[][] vis = new boolean[grid.length][grid[0].length];
        vis[0][0] = true;

        q.add(new int[]{0, 0, 1});
        while(!q.isEmpty()){
            int[] p = q.poll();
            int i = p[0], j = p[1], dis = p[2];

            if(i == n-1 && j== n-1) ans = Math.min(ans, dis);
             System.out.println(i + " i " + j + " j " + ans + " ans ");

            for(int d[] : dir){
                int a = i+d[0], b = j+d[1];
                // System.out.println(" a " + a + " b " + b );

                //out of boud stop
                //already visited stop
                //is 1 stop
                if(a>=0 && b>=0 && a<n && b<n && grid[a][b] == 0 && !vis[a][b]){
                    //new dist
                    int newdis = dis+1;
                    // System.out.println(a + " a " + b + " b " + newdis + " dis ");

                    //new dis is smaller
                    // if(newdis < path[a][b]) {
                    //     path[a][b] = newdis;
                    //     q.add(new int[]{a, b, newdis});
                    //     vis[a][b] = true; //we simply discard visited states - how does that helps?
                    //     // System.out.println(Arrays.deepToString(path));

                    // }
                    q.add(new int[]{a, b, newdis});
                    vis[a][b] = true;
                }
            }
        }
        // System.out.println(Arrays.deepToString(path));
        return ans == Integer.MAX_VALUE ? -1 :  ans;
    }
}
