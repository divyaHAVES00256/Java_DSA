import java.util.Arrays;
import java.util.PriorityQueue;

public class Path_with_min_efffort {
    //classic dijkstra problem
     public int minimumEffortPath(int[][] h) {
        int n = h.length;
        int m = h[0].length;
        boolean vis[][] = new boolean[n][m]; //we do not need it here

        int dir[][] = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };
        int[][] ans = new int[n][m];
        for(int i = 0; i<n; i++){
            Arrays.fill(ans[i], Integer.MAX_VALUE);
        }

        ans[0][0] = 0;

        PriorityQueue<int[]> pq =  new PriorityQueue<>(
            (a, b) -> Integer.compare(a[2], b[2])
        );

        pq.add(new int[]{0, 0, 0});

        while(!pq.isEmpty()){
            int[] p = pq.poll();
            int i = p[0];
            int j = p[1];
            int dis = p[2];

            if( i == n-1 && j == m-1) return dis;

            for(int r = 0; r<dir.length; r++){
                int[] d = dir[r];
                int a = i+d[0], b = j+d[1];

                if(a>=0 && b>=0 && a<n && b<m){
                    //newdis is thier max abs distance
                    int newdis = Math.max(Math.abs(h[a][b]-h[i][j]), dis);

                    if(newdis<ans[a][b]) {
                        pq.add(new int[]{a, b, newdis});
                        ans[a][b] = newdis;
                    }
                }
            }
        }

        //  System.out.println(Arrays.deepToString(ans));

        return 0;
    }
}
