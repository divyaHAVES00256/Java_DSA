// package print-lc_subsequnce;

public class main {
    public int longestCommonSubsequence(String x, String y) {
        int n = x.length();
        int m = y.length();
        
        int dp[][] = new int[n+1][m+1];

        int ans = bottomup(x, y, n, m, dp);

        print(x, y, n, m, dp);

        return ans;
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

    void print(String x, String y, int n, int m, int dp[][]){
        int i = n;
        int j = m;
        StringBuilder  ans = new StringBuilder();
        while(i>0 && j>0){
            //equla -> add once
            if(x.charAt(i-1) == y.charAt(j-1)){
                ans.insert(0, x.charAt(i-1));
                i--; j--;
            } 
            //not equal -> move to longer one
            else {
                if(dp[i-1][j] > dp[i][j-1]){
                    i--;
                } else {
                    j--;
                }
            }
        }

        System.out.println(ans);
    }
}
