package palindrom_partitioning;

import java.util.Arrays;

/*
store an dreturn subproblems if they are alraedy solved
 */
public class OptimisedMemo {
     static int palPartition(String s) {
        int n = s.length();
        
        int dp[][] = new int[n+1][n+1];
        for(int i = 0; i<=n; i++){
            Arrays.fill(dp[i], -1);
        }
        return memo(s, 0, n-1, dp);
    }
    //mcm
    //0, n-1
    //
    static int memo(String s, int i, int j, int[][] dp){
        if(i>=j || ispalin(s, i, j)) {
            return 0;
        }
        if(dp[i][j]!=-1){ 
            return dp[i][j]; 
        }
        
        int min = Integer.MAX_VALUE;
        for(int k = i; k<=j-1; k++){
            //left/reight
            //further optimization by checking subproblems as well
            int left;
            int right;
            
            if(dp[i][k]!=-1){
                left =  dp[i][k];
            } else {
                left = memo(s, i, k, dp);
                dp[i][k] = left;
            }
            
            if(dp[k+1][j]!=-1){
                right = dp[k+1][j];
            } else {
                right = memo(s, k+1, j, dp);
                dp[k+1][j] = right;
            }
            
            //cost
            int cost = left+right+1;
            min = Math.min(min, cost);
        }
        dp[i][j] = min;
        
        return dp[i][j];
    }
    
    static boolean ispalin(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        
        return true;
    }
}
