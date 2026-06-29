package longest_common_subsequence;

import java.util.Arrays;

public class Memoization {
    //evry charahter has the choice of taken or not taken plus already visited states
    //time = n*m
    //space = n*m
    public int longestCommonSubsequence(String x, String y) {
        int n = x.length();
        int m = y.length();
        
        int dp[][] = new int[n+1][m+1];
        for(int i = 0; i<=n; i++){
            Arrays.fill(dp[i], -1);
        }
        

        return memo(x, y, n, m, dp);
    }

    int memo(String x, String y, int n, int m, int dp[][]){
        // System.out.println("before " + dp[n][m] + " " + n + " " + m);

        //base
        //striing is empty
        if(n == 0 || m == 0){
            return 0;
        }

        //if this state is already visited
        if(dp[n][m]!=-1){
            return dp[n][m];
        }

        //choice diagram
        //last char is equal
        if(x.charAt(n-1) == y.charAt(m-1)){
            dp[n][m] =  memo(x, y, n-1, m-1, dp)+1;
        } 
        //kast char not equal
        //return max
        else {
            dp[n][m] = Math.max(memo(x, y, n, m-1, dp), memo(x, y, n-1, m, dp));
        }
        // System.out.println("after " + dp[n][m] + " " + n + " " + m);


        //final answer when whole memo brach is done
        return dp[n][m];
    }
}
