package Rat_In_Maze;
import java.util.ArrayList;

public class Optimal {
    //time: 4^(n*n)
    //space: n*n
    private int dirx[] = { 1,  0, 0, -1};
    private int diry[] = {0, -1, 1, 0};
    private char move[] = {'D', 'L', 'R', 'U'};
    
    public ArrayList<String> ratInMaze(int[][] maze) {
        int n = maze.length;
        ArrayList<String> ans = new ArrayList<>();
        
        // Early exit
        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) {
            return ans;
        }
        
        // OPTIMIZATION 1: Mark the starting cell as visited directly in the maze
        maze[0][0] = 0;
        
        // OPTIMIZATION 2: Pass a StringBuilder instead of an empty String
        backtrack(0, 0, n, new StringBuilder(), ans, maze);
        
        // (Optional) Restore the start cell if you need to keep the original maze intact
        maze[0][0] = 1;
        
        return ans;
    }
    
    void backtrack(int i, int j, int n, StringBuilder path, ArrayList<String> ans, int[][] maze) {
        // Base case
        if (i == n - 1 && j == n - 1) {
            ans.add(path.toString());
            return;
        }
        
        // Choices of directions
        for (int d = 0; d <= 3; d++) {
            int x = i + dirx[d];
            int y = j + diry[d];
            
            // Check bounds AND if the cell is a 1 (meaning it's safe and unvisited)
            if (x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1) {
                
                // Mark visited in the maze itself
                maze[x][y] = 0;
                
                // Append current move to the path
                path.append(move[d]);
                
                // Recursion
                backtrack(x, y, n, path, ans, maze);
                
                // BACKTRACK: Unmark visited and remove the last move
                path.deleteCharAt(path.length() - 1);
                maze[x][y] = 1; 
            }
        }
    }
}
