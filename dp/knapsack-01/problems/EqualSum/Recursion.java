package problems.EqualSum;
//find if array can be partition into equal sum
//reduced to -> subset_sum(arr, target = (totalsum/2), dp[n+1][target+1])

public class Recursion {
    static boolean recur(int[] arr, int sum, int n){
        if(sum==0) return true;
        if(n==0) return false;

        if(arr[n-1]<=sum){
            //choose
            //cant choose
            return recur(arr, sum-arr[n-1], n-1) || recur(arr, sum, n-1);
            
        } else {
            //we cant chhose
            return recur(arr, sum, n-1);
        }
    }

    public static boolean canPartition(int[] nums) {
        //1
        int total = 0;
        for(int i :  nums){
            total+=i;
        }

        //2
        if(total%2 != 0) return false;

        //3
        //we dont actually need to do that
        // for(int i = 0; i<=total; i++){
        //     if(recur(arr, i, nums.length, total)) return true;
        // }

        //check for total/2 only -> as this is the only possiblily where every elment will be covered and with equal sum partition
        return recur(nums, total/2, nums.length);
        
    }
}




