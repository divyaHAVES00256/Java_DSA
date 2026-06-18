import java.util.*;

// Top-Down DP → Recursion + Memoization
//tc = (N+1) × (W+1)
//sc = dp table + recursive stack = (N+1)×(W+1) + N 
public class Memoization {

    public static int knapsack(int[] wt, int[] prof, int cap, int n, int[][] dp) {

        // Base case
        if (n == 0 || cap == 0) {
            return 0;
        }

        // Already calculated
        if (dp[n][cap] != -1) {
            return dp[n][cap];
        }

        // Choice diagram
        if (wt[n - 1] <= cap) {

            // Take OR Don't Take
            dp[n][cap] = Math.max( prof[n - 1] + knapsack(wt, prof,cap - wt[n - 1], n - 1, dp),
                                                knapsack(wt, prof,cap, n - 1, dp)
                        );
        } else {

            // Cannot take item
            dp[n][cap] = knapsack(wt, prof, cap, n - 1, dp);
        }

        return dp[n][cap];
    }

    public static void main(String[] args) {

        int[] wt = {1, 3, 4, 5};
        int[] prof = {1, 4, 5, 7};

        int cap = 7;
        int n = wt.length;

        int[][] dp = new int[n + 1][cap + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int maxProf = knapsack(wt, prof, cap, n, dp);

        System.out.println("Maximum Profit = " + maxProf);
    }
}