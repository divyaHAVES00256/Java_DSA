package problems.SubsetSum;

public class BottomUp {
    static Boolean isSubsetSum(int arr[], int sum) {
        boolean  dp[][] = new boolean [arr.length+1][sum+1]; 
        
        for(int i = 0; i<=arr.length; i++){
            for(int j = 0; j<=sum; j++){
                if(i == 0 && j == 0) dp[i][j] = true;
                else if(j == 0) dp[i][j] = true;
                // else if(i == 0) dp[i][j] = false;
            }
        }

        //BOTTOM UP: 
        return bottomup(arr, sum, arr.length, dp);
        
        
        
    }

    // tc: (n×sum) sc: (n×sum)
    static boolean bottomup(int arr[], int sum, int n, boolean dp[][]){
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=sum; j++){
                if (arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                } else if(arr[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][sum];
    }
   
}
