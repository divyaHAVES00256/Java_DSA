// package knapscak-unbounded.Rod_Cutting;

public class BottomUp {
    public int cutRod(int[] price) {
        // 01 knapsack
        //dp[item weight array size][bag size], profit arr, wrieght arr
        
        //unbounded
        //dp[item length size][size we can cut it into]
        //length n and cut peices in n length -> mx profix
        
        
        int n = price.length; //this n can be diffrent as well, here length array and n are same in size
        
        int[] length = new int[n]; //this length array can be diffrent as well like given the price of cut, 3, 1, 2 only and n = 7
        
        for(int i = 0; i<n; i++) length[i] = i+1;
        
        int dp[][]  = new int[length.length+1][n+1];
        
        //INTITIALIZATION :
        //no length array or no rod -> proft 0
        
        //hence this aboce intialization is wrong
        // for(int i = 0; i<=n; i++){
        //     for(int j = 0; j<=n; j++){
        //         // if(j == 0 && i == 0) dp[i][j] = 0;
        //         // if(j == 0 && i>0) dp[i][j] = price[i-1];
        //     }
        // }
        
        bottomup(n, length, price, dp);
        return dp[n][n];
    }
    
    void bottomup(int n, int[] length, int[] price, int[][] dp){
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                if(length[i-1]<=j){
                    dp[i][j] = Math.max(price[i-1]+dp[i][j - length[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
    }
}
