package problems.EqualSum;

public class Memoization{
    public boolean canPartition(int[] nums) {
        //1
        int total = 0;
        for(int i :  nums){
            total+=i;
        }

        //2
        if(total%2 != 0) return false;

        //3
        Boolean[][] dp = new Boolean[nums.length+1][total/2 + 1];
        for(int i = 0; i<dp.length; i++){
            for(int j = 0; j<dp[0].length; j++){
                if(i == 0)dp[i][j] = false;;
                if(j == 0)dp[i][j] = true;
            }
        }
        return memo(nums, total/2, nums.length, dp);
    }

    boolean memo(int[] arr, int sum, int n, Boolean[][] dp){
        if(sum==0) return true;
        if(n==0) return false;

        if(dp[n][sum] != null){
            return dp[n][sum];
        }

        if(arr[n-1]<=sum){
            //choose
            //cant choose
            dp[n][sum] = memo(arr, sum-arr[n-1], n-1, dp) || memo(arr, sum, n-1, dp);
            
        } else {
            //we cant chhose
            dp[n][sum] = memo(arr, sum, n-1, dp);
        }

        return dp[n][sum];
    }
}