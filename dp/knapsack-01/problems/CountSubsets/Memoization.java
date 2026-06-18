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
        if (k == 0) {
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

        int[] arr = {2, 3, 5, 16, 8, 10};
        int k = 10;

        int ans = perfectSum(arr, k);

        System.out.println("Count of subsets = " + ans);
    }
}


