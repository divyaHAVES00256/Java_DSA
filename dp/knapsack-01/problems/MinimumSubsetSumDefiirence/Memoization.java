// TC = O(n * sum) (eah state is computed only once hence even if it looks like sum^2*n it is actually not)
// SC = O(n * sum)
public class Memoization {
     public int minDifference(int arr[]) {
        // code here
        int sum = 0;
        for(int i : arr){
            sum+=i;
        }
        int ans = Integer.MAX_VALUE;
        
        Boolean[][] dp = new Boolean[arr.length+1][sum/2 +1];
        
        for(int i = 0; i<=sum/2; i++){ //sum/2
            if(memo(arr, i, arr.length, dp)) ans = Math.min(ans, Math.abs(i - (sum-i))); //i*n
        }
        
        return ans;
    }
    
    boolean memo(int[] arr, int i, int n, Boolean[][] dp){
        if(i == 0) return true;
        if(n == 0) return false;
        
        if(dp[n][i] != null){
            return dp[n][i];
        }
        
        if(arr[n-1]<=i){
            dp[n][i] =  memo(arr, i-arr[n-1], n-1, dp) || memo(arr, i, n-1, dp);
        } else{
            dp[n][i] = memo(arr, i, n-1, dp);
        }
        
        return dp[n][i];
    }
}
