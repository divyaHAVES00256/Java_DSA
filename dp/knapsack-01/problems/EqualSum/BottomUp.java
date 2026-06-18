package problems.EqualSum;

public class BottomUp {
    public boolean canPartition(int[] nums) {
        //1
        int total = 0;
        for(int i :  nums){
            total+=i;
        }

        //2
        if(total%2 != 0) return false;

        //3
        boolean[][] dp = new boolean[nums.length+1][total/2 + 1];
        for(int i = 0; i<dp.length; i++){
            for(int j = 0; j<dp[0].length; j++){
                if(i == 0)dp[i][j] = false;;
                if(j == 0)dp[i][j] = true;
            }
        }
        return bottomup(nums, total/2, nums.length, dp);
    }

    boolean bottomup(int[] arr, int sum, int n, boolean[][] dp){
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=sum; j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][sum];
    }
}
