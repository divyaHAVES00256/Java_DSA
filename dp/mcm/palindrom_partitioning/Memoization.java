package palindrom_partitioning;

import java.util.Arrays;
//time: n^3 + n
//Total Time = (Number of Unique States)*(Work Done Per State)
//for every dp[i][j] -> check ispalin + partition(i to j)

//space: n^2
public class Memoization {
    static int palPartition(String s) {
        int n = s.length();
        
        int dp[][] = new int[n+1][n+1];
        for(int i = 0; i<=n; i++){
            Arrays.fill(dp[i], -1);
        }
        return memo(s, 0, n-1, dp);
    }

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
            int left = memo(s, i, k, dp);
            int right = memo(s, k+1, j, dp);
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
