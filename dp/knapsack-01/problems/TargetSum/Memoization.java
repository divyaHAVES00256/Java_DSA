package problems.TargetSum;

import java.util.Arrays;

public class Memoization {
    public int findTargetSumWays(int[] nums, int diff) {
        //simialar to the count of subset whose diffrrence equals diff(target)

        int sum = 0;
        for(int i : nums){
            sum+=i;
        }
        //if neg or odd edge case
        if(sum+diff < 0 || (sum+diff)%2 != 0) return 0;

        int target = (sum+diff)/2;

        int n = nums.length;
        int[][] dp = new int[n+1][target+1];

        for(int i = 0; i<=n; i++){
            Arrays.fill(dp[i], -1);
        }

        return memo(nums, n, target, dp);
    }

    int memo(int[] nums, int n, int tar, int[][] dp){
        if(n == 0 && tar == 0) return 1;
        if(n == 0) return 0;
        
        if(dp[n][tar]!=-1) return dp[n][tar];

        if(nums[n-1]<=tar){
            dp[n][tar] =  memo(nums, n-1, tar-nums[n-1], dp)+memo(nums, n-1, tar, dp);
        } else {
            dp[n][tar] =  memo(nums, n-1, tar, dp);
        }

        return  dp[n][tar];
    }
}
