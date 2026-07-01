package longest_palindromic_subsequence;

public class BottomUp {
    public int longestPalinSubseq(String s) {
        //problems is reduced to lc
        //return lcs(a, rev(a))
        // time: n*n
        // space : n*n + n
        String a = s;
        String b = new StringBuilder(s).reverse().toString();
        
        int n = a.length();
        int m = b.length();
        
        int dp[][] = new int[n+1][m+1];
        
        return lcs(a, b, n, m, dp);
    }
    
    int lcs(String a, String b, int n, int m, int dp[][]){
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
}
