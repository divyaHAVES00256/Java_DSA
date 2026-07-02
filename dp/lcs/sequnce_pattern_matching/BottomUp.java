package sequnce_pattern_matching;

public class BottomUp {
    //2d DP
    //tc, sc : n^2
    public boolean isSubSeq(String a, String b) {
        // code here
        int n = a.length();
        int m = b.length();
        int dp[][] = new int[n+1][m+1];
        
        int l = lcs(a, b, n, m, dp);
        
        if(l == n) return true;
        return false;
    }
    
    int lcs(String a, String b, int n, int m, int[][] dp){
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[n][m];
    }

    //1d DP
    //tc: n^2
    //sc: n
}
