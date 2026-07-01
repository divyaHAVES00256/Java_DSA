package min_delete_to_make_string_palindrome;

public class BottomUP {
    public int minDeletions(String s) {
        // looking corefully
        // we need to delete chars which are extra than lcs(a, rev(a))
        String a = s;
        String b = new StringBuilder(s).reverse().toString();
        
        int n = a.length();
        
        int[][] dp = new int[n+1][n+1];
        
        return n-lcs(a, b, n, dp);
    }
    
    int lcs(String a, String b, int n, int[][] dp){
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        
        return dp[n][n];
    }
}
