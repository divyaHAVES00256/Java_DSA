public class BottomUp{
    public int minOperations(String a, String b) {
        //if we look into it carefully
        //this is lcs problem
        //this lcs is common in both
        //now delete -> s1.length-lcs -> these are extra elemnts int s1
        //and -> s2.length-lcs -> these are the extra elemnts needed to be added int s1 to make 
        //it similar to s2
        //output =  s2.leng-lcs + s1.leng-lcs
        int n = a.length();
        int m = b.length();
        int dp[][] = new int[n+1][m+1];
        
        int l = lcs(a, b, n, m, dp);
        
        return (n-l) + (m-l);
    }
    
    int lcs(String a, String b, int n, int m, int[][] dp){
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(a.charAt(i-1) == b.charAt(j-1)) dp[i][j] = dp[i-1][j-1]+1;
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[n][m];
        
    }
}