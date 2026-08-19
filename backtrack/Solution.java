import java.util.ArrayList;

public class Solution {
    
    private  int dirx[];
    private  int diry[];
    private char move[];
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int n = maze.length;
        
        //lrxicographically->possible direction + what move it corresponds
        dirx = new int[]{ 1,  0, 0, -1};
        diry = new int[]{ 0, -1, 1,  0};
        move = new char[]{'D', 'L', 'R', 'U'};
        
        //stores all possible answers
        ArrayList<String> ans = new ArrayList<>();
        
        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) {
            return ans;
        }
        
        //check if our current place visited
        boolean[][] isvis = new boolean[n][n];
        isvis[0][0] = true;
        
        
        //function call
        backtrack(0, 0, n, "", isvis, ans, maze);
        
        return ans;
    }
    void backtrack(int i, int j,  int n, String op, boolean[][] vis, ArrayList<String> ans, int[][] maze){
        //base
        // System.out.println(i + " " + j + " " + op);
        if(i == n-1 && j == n-1){
            ans.add(op);
            return;
        }
        
        //choices of directions
        //up, down, left, right
        for(int d = 0; d<=3; d++){
            int x = i+dirx[d];
            int y = j+diry[d];
            
            //new direction is in bound + is not visited + and isvalid(contains 1 only)
            if(x>=0 && x<n && y>=0 && y<n && !vis[x][y] && isvalid(x, y, maze)){
                //mark vis
                vis[x][y] = true;
                
                //recursion
                backtrack(x, y, n, op+move[d], vis, ans, maze);
                
                //mark unvisited to check other places
                //do we need backtrack?
                //Array is pass by reference, we might probably need to undo the place we have already visited
                vis[x][y] = false;
            }
        }
    }
    
    boolean isvalid(int x, int y, int[][] maze){
        if(maze[x][y] == 1) return true;
        return false;
    }
}