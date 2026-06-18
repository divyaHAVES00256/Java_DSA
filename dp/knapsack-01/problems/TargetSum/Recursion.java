package problems.TargetSum;

public class Recursion {
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

        return recur(nums, n, target);
    }

    int recur(int[] nums, int n, int tar){
        if(n == 0 && tar == 0) return 1;
        if(n == 0) return 0;
        

        if(nums[n-1]<=tar){
            return recur(nums, n-1, tar-nums[n-1])+recur(nums, n-1, tar);
        } else {
            return recur(nums, n-1, tar);
        }
    }
}
