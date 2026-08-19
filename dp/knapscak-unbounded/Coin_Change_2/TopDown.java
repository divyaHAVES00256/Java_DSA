// package knapscak-unbounded.Coin_Change_2;

import java.util.Arrays;

public class TopDown {
    public int change(int amt, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n+1][amt+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return recur(n, amt, coins, dp);
    }

    int memo(int n, int amt, int[] coins, int[][] dp){
        if(n == 0 && amt == 0) return 1;
        if(n == 0) return 0;

        if(dp[n][amt] != -1) return dp[n][amt];

        if(coins[n-1]<=amt){
            dp[n][amt] = memo(n, amt-coins[n-1], coins, dp)+memo(n-1, amt, coins, dp);
        } else {
            dp[n][amt] = memo(n-1, amt, coins, dp);
        }

        return dp[n][amt];
    }
}
