package nqueen;

import java.util.ArrayList;
import java.util.List;

public class backtrack {
    //In the optimized row-by-row logic -> 
    //1st row has n choices to place a queen
    //2nd row has n-1 choices to place a queen
    //and so on
    //time: n * n-1 * n-1 ... = nfactorial

    //space: n*n
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();

        List<String> temp = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n; i++)sb.append('.');
        for(int i = 0; i<n; i++)temp.add(sb.toString());

        int row = 0;
        int count = n;

        find(row, temp, n);

        return ans;
    }

    //we are doing dfs
    //each time we go to a row -> check each cell in it ->  and try to fill the queen
    void find(int row, List<String> temp, int n) {
        // 1. Base case: Did we place all 'n' queens?
        if (row == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        // 2. Try placing a queen in every column of the CURRENT row
        for (int col = 0; col < n; col++) {
            
            // 3. Is this specific spot safe?
            if (isvalid(row, col, temp)) {
                
                //place queen
                StringBuilder sb = new StringBuilder(temp.get(row));
                sb.setCharAt(col, 'Q');
                temp.set(row, sb.toString());

                // RECURSION: Move immediately to the next row!
                find(row + 1, temp, n);

                ///unplace queen ->  backtrack
                sb.setCharAt(col, '.');
                temp.set(row, sb.toString());
            }
        }
    }

    //since we are filling from the top coloums
    //this facts mkes us easier to check is valid 
    //here we only look for upper half filled coloum only and lower half has not been fille dyet
    boolean isvalid(int row, int col, List<String> temp) {
        int n = temp.size();
        
        // 1. Check straight UP (Same column)
        //row - 1 to 0
        for (int i = 0; i < row; i++) {
            if (temp.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        
        // 2. Check Upper-Left Diagonal
        //row-1 col-1 to 0 0
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (temp.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        
        // 3. Check Upper-Right Diagonal
        //row - 1 col+1 to 0 n
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (temp.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        
        return true; // Safe
    }
}
