package egg_dropping_problem;

import java.util.Arrays;

public class BSOptimisation {
    //if i look carefully -> it has the resumples of binary serach
    // time : e * flogf
    // space : e*f
    int dp[][];
    
    public int superEggDrop(int e, int f) {
        dp = new int[e + 1][f + 1];
        for (int i = 0; i <= e; i++) {
            Arrays.fill(dp[i], -1);
        }
        return memo(e, f);
    }

    int memo(int e, int f) {
        // Base cases
        if (f == 0) return 0;
        if (f == 1) return 1;
        if (e == 1) return f;

        // Return cached result
        if (dp[e][f] != -1) return dp[e][f];
        
        int min = Integer.MAX_VALUE;
        
        // Binary Search instead of linear for-loop
        int low = 1, high = f;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            int left = memo(e - 1, mid - 1); // Egg breaks
            int right = memo(e, f - mid);    // Egg survives
            
            // Worst case from floor 'mid'
            int temp = 1 + Math.max(left, right);
            min = Math.min(min, temp);
            
            // If left is less than right, the intersection is to our right,
            // so we must move our search window UP.
            if (left < right) {
                low = mid + 1;
            } 
            // If left is greater than right, the intersection is to our left,
            // so we must move our search window DOWN.
            else {
                high = mid - 1;
            }
        }
        
        // Cache and return
        dp[e][f] = min;
        return min;
    }
}
