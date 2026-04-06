import java.util.LinkedList;
import java.util.Queue;

public class FloodFill{
    //using bfs -> similar to rotten oranges(can be done using dfs as well)
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        int[][] ans = new int[image.length][image[0].length];
        
        //change pixles
        while(!q.isEmpty()) {
            int val[] = q.poll();
            int i = val[0], j = val[1];
            ans[val[0]][val[1]] = color;

            //left
            while(j+1<image[0].length && ans[i][j+1]!=color && image[i][j+1] == image[i][j]){
                ans[i][j+1] = color;
                q.add(new int[]{i, j+1});
            }
            //right
            while(j-1>=0 && ans[i][j-1]!=color && image[i][j-1] == image[i][j]){
                ans[i][j-1] = color;
                q.add(new int[]{i, j-1});
            }
            //top
            while(i-1>=0 && ans[i-1][j]!=color && image[i-1][j] == image[i][j]){
                ans[i-1][j] = color;
                q.add(new int[]{i-1, j});
            }
            //botom
            while(i+1<image.length && ans[i+1][j]!=color && image[i+1][j] == image[i][j]){
                ans[i+1][j] = color;
                q.add(new int[]{i+1, j});
            }
        }

        //now add isolated pix from image
        for(int i = 0; i<image.length; i++){
            for(int j = 0; j<image[0].length; j++){
                if(ans[i][j] != color) ans[i][j] = image[i][j];
            }
        }

        return ans;
    }
}