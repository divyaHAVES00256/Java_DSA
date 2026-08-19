// package knapscak-unbounded.Coin_Change_1;

public class BottomUp {
     public int coinChange(int[] coins, int sum) {
        int n = coins.length;
        int[][] dp = new int[coins.length+1][sum+1];
        
        //INITIALIZE
        //0th col
        for(int i = 0; i<=n; i++){
            dp[i][0] = 0;
        }
        //0th row
        //why intialize with Integer.MAX_VALUE-1?
        for(int i = 0; i<=sum; i++){
            dp[0][i] = Integer.MAX_VALUE-1;
        }

        //1st row
        //why we require this intialization?
        for(int i = 1; i<=sum; i++){
            if(i%coins[0] == 0){
                dp[1][i] = i/coins[0];
            } else {
                dp[1][i] = Integer.MAX_VALUE-1;
            }
        }


        return bottomup(coins.length, sum, coins, dp);
    }

    //how dp is filled here?
    int bottomup(int n, int sum, int[] coins, int dp[][]){
        for(int i = 2; i<=n; i++){
            for(int j = 1; j<=sum; j++){
                if(coins[i-1]<=j){
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        if(dp[n][sum] == 2147483646) return -1;

        return dp[n][sum];
    }
}
