package mcm.mcm;

import java.util.Arrays;

public class Memoization {
    //tc: n*n*n
    //for every i(n^2) ->  we try n partitions
    // Time = States × Work per state = n^2 * n
    //sc: n*n (We use a 2D dp table of size n x n, plus recursion stack O(n))
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int i = 1;
        int j = n-1;
        
        //intialize dp
        int[][] dp = new int[n+1][n+1];
        for(int c = 0; c<=n; c++){
            Arrays.fill(dp[c], -1);
        }
        
       int ans = memo(arr, i, j, dp);
       return ans;
        
    }
    
    static int memo(int[] arr, int i, int j, int[][] dp){
        //base
        //no elemnt or out of bound 
        if(i>=j) return 0;
        
        //  System.out.println(dp[i][j]);
        
        //subproblem already calculated
        if(dp[i][j] != -1) return dp[i][j];
        //split choices
        int min = Integer.MAX_VALUE; //calculates local and gloab cost with min value
        for(int k = i; k<=j-1; k++){
            int c = arr[i-1]*arr[k]*arr[j]; //merge cost
            
            int temp = memo(arr, i, k, dp)+memo(arr, k+1, j, dp); //left and right cost

            min = Math.min(min, temp+c); //min out of all split possible
            
            dp[i][j] = min;
        }
        
        //the particualr branch has been completed -> update here final
        //if you update in the for loop -> you have to keep doing ot every completion
        //but we just want the final minimum value of the i, j
        dp[i][j] = min;
        
        //final answer
        return dp[i][j];
    }
}
