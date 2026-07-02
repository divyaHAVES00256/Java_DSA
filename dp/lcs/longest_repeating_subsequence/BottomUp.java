package longest_repeating_subsequence;
public class BottomUp {
    public int LongestRepeatingSubsequence(String s) {
        // code here
        //a and b both same
        //where ith and jth is not same index of s
        //same index ke char nhi chahiye hme 
        int dp[][] = new int[s.length()+1][s.length()+1];
        return lcs(s, s, s.length(), dp);
    }
    
    int lcs(String a, String b, int n, int[][] dp){
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                //as we do not want the lcs to conatin the same index
                //as per the question
                if(i == j){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                } 
                //now all steps are same as the lcs
                else if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[n][n];
    }
}
