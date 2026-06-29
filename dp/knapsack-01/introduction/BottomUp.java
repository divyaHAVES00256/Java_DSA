import java.util.Arrays;
//Bottom-Up DP → uses iteration/tabulation
//tc = N*W
//sc = N*W
//max profit 
public class BottomUp {
    public static int knapsack(int[] wt, int[] prof, int cap, int n, int[][] dp){
        //1 INTIALIZATION (if n==0 or cap==0) -> no profit
        for(int i = 0; i<dp.length; i++){
            for(int j = 0; j<dp[0].length; j++){
                if(i == 0 || j == 0) dp[i][j] = 0;
            }
        }

        //2 ITERATIVE CALLS
        //i = n
        //j = w or cap
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=cap; j++){
                //a) possible to add weight in the bag
                if(wt[i-1]<=j){
                    dp[i][j] = Math.max(prof[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]);
                } 
                //b) impossible to add weight in the bag
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n][cap];
    }

    public static void main(String[] args) {
        int n = 4;
        int[] wt = {1, 3, 4, 5};
        int[] prof = {1, 4, 5, 7};
        int cap = 7;
        
        // dp[1][x] use first item
        // 0 capacity → 0 profit
        //hence size+1
        int[][] dp = new int[n+1][cap+1];

        int maxProf = knapsack(wt, prof, cap, n, dp);

        System.out.println(maxProf);
    }
}
