package longest_common_subsequence;

public class BottomUp {
    //evry charahter has the choice of taken or not taken plus dp table
    //time = n*m
    //space = n*m
    public int longestCommonSubsequence(String x, String y) {
        int n = x.length();
        int m = y.length();
        
        int dp[][] = new int[n+1][m+1];

        return bottomup(x, y, n, m, dp);
    }

    int bottomup(String x, String y, int n, int m, int dp[][]){
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                //choice diagram
                //euqal
                if(x.charAt(i-1) == y.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                } 
                //unequal
                //fill with max
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        } 
        return dp[n][m];
    }
}
