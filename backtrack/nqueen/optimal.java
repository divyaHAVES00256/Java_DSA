package nqueen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class optimal {
    //using hasing to remove the isvalid function compeltly to O(1)
    List<List<String>> ans;
    
    // Arrays to track under-attack zones in O(1) time
    boolean[] cols;
    boolean[] mainDiag;
    boolean[] antiDiag;

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        
        // Initialize tracking arrays
        cols = new boolean[n];
        mainDiag = new boolean[2 * n - 1];
        antiDiag = new boolean[2 * n - 1];
        
        // Initialize the empty board
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        // Start the DFS from row 0
        backtrack(0, board, n);
        
        return ans;
    }

    private void backtrack(int row, char[][] board, int n) {
        // Base Case: All queens have been placed safely
        if (row == n) {
            ans.add(construct(board));
            return;
        }

        // Try placing a queen in every column of the current row
        for (int col = 0; col < n; col++) {
            
            // Calculate the unique index for this cell's diagonals
            int mainIdx = row - col + n - 1;
            int antiIdx = row + col;

            // $O(1)$ VALIDATION: Skip if the column or either diagonal is attacked
            if (cols[col] || mainDiag[mainIdx] || antiDiag[antiIdx]) {
                continue;
            }

            // --- PLACE QUEEN ---
            board[row][col] = 'Q';
            cols[col] = true;
            mainDiag[mainIdx] = true;
            antiDiag[antiIdx] = true;

            // --- RECURSION ---
            backtrack(row + 1, board, n);

            // --- BACKTRACK (UN-PLACE QUEEN) ---
            board[row][col] = '.';
            cols[col] = false;
            mainDiag[mainIdx] = false;
            antiDiag[antiIdx] = false;
        }
    }

    // Helper function to convert the char[][] board into a List<String>
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}
