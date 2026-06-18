package problems.SubsetSum;

public class Memoization {
    static Boolean isSubsetSum(int arr[], int sum) {
        
        //MEMOIZATION(top down):
        //Boolean can store null value apart fron true, and false
        //hence best for memo
        Boolean dp[][] = new Boolean [arr.length+1][sum+1]; 
        for(int i = 0; i<=arr.length; i++){
            for(int j = 0; j<=sum; j++){
                if(i == 0 && j == 0) dp[i][j] = true;
                else if(j == 0) dp[i][j] = true;
                // else if(i == 0) dp[i][j] = false;
            }
        }
        return memo(arr, sum, arr.length, dp);
        
        
        
    }
    
    //  tc: (n×sum) sc: (n×sum)+n  (table + recur stack)
    static boolean memo(int arr[], int sum, int n, Boolean dp[][]){
        if(n == 0 && sum == 0) return  true;
        if(sum == 0) return true;
        if(n == 0) return false;
        
        if(dp[n][sum]!=null){
            return dp[n][sum];
        }
        
        //choices
        if(arr[n-1] <= sum){
            dp[n][sum] =  memo(arr, sum-arr[n-1], n-1, dp) || memo(arr, sum, n-1, dp);
        } else {
            dp[n][sum] = memo(arr, sum, n-1, dp);
        }
        return dp[n][sum];
    }
}
