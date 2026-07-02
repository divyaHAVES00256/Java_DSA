
public class BottomUp {
    public int minInsertions(String s) {
        String a = s;
        String b = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int dp[][] = new int[n+1][n+1];
        return n-lcs(a, b, n, dp);
    }
    int lcs(String a, String b, int n, int[][] dp){
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][n];
    }
}
