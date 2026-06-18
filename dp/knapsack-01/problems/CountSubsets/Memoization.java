//tc : n*k
//sc : n*k + n
import java.util.*;

public class Memoization {
    public static int perfectSum(int[] arr, int k) {

        int n = arr.length;

        int[][] dp = new int[n + 1][k + 1];

        // initialize all cells with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return memo(arr, k, n, dp);
    }

    static int memo(int[] arr, int k, int n, int[][] dp) {
         System.out.println(dp[n][k] + " before "+ n + " "+k);

        // sum formed
        //ISSUE : we did not simply return 1 when k == 0
        //cuz target the array may contains 0 {0,0,0}, and to encounter all 0s we must not prematuarly stop memo
        // if ( k == 0) {
        //     return 1; // <--- Premature exit! 
        // }
        
        //FIX
        if (n == 0 && k == 0) {
            return 1; 
        }

        // no elements left
        if (n == 0) {
            return 0;
        }

        // already computed
        if (dp[n][k] != -1) {
            return dp[n][k];
        }

        // include + exclude
        if (arr[n - 1] <= k) {

            dp[n][k] =
                memo(arr, k - arr[n - 1], n - 1, dp)
                +
                memo(arr, k, n - 1, dp);

        } else {

            dp[n][k] =
                memo(arr, k, n - 1, dp);
        }
        System.out.println(dp[n][k] + " after "+ n + " "+k);

        return dp[n][k];
    }

    public static void main(String[] args) {

        int[] arr = {0,0};
        int k = 0;

        int ans = perfectSum(arr, k);

        System.out.println("Count of subsets = " + ans);
    }
}


