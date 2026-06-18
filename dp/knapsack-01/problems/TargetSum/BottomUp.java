package problems.TargetSum;
//this question is basically the another form of finding "count subset with diffrence "diff" "
public class BottomUp {
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
        dp[0][0] = 1;

        bottomup(nums, n, target, dp);

        return dp[n][target];
    }

    void bottomup(int[] nums, int n, int target, int[][] dp){
        for(int i = 1; i<=n; i++){
            for(int j = 0; j<=target; j++){
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j - nums[i-1]]+dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
    }
}
