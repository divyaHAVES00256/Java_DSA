package longest_common_substring;

public class BottomUp {
    // basically -> here we also check everystate but using dp 
    //similarly to recur
    //andany cell could be the max -> like recur
    public int longCommSubstr(String x, String y) {
        // code here
        int n = x.length();
        int m = y.length();
        
       int dp[][] = new int[n+1][m+1];
       return bottomup(x, y, n, m, dp);
    }
    int bottomup(String x, String y, int n, int m, int dp[][]){ //min(n, m)
        // System.out.println(n + " " + m);
        int ans = 0;
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                //equal
                if(x.charAt(i-1) == y.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                //not equal -> breaks substring
                else {
                    dp[i][j] = 0;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        
        return ans;
        
    }
}
