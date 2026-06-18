// TC = O(n * sum) 
// SC = O(n * sum)
public class Bottomup {
    public int minDifference(int arr[]) {
        // code here
         int n = arr.length;
        int sum = 0;
        for(int i : arr){
            sum+=i;
        }
        int ans = Integer.MAX_VALUE;
        
        //INTIALIZATION
        // range for subset sum possability(0 to sum/2)
        boolean[][] dp = new boolean[n+1][(sum/2)+1];
        for(int i = 0; i<=n; i++){
            dp[i][0] = true;
        }
       
        //BUILD DP
        bottomup(arr, sum/2, n, dp);
        
        //FIND MIN DIFFRENCE
        //the last row will tell whether that summation is present or not
        for(int i = 0; i<=sum/2; i++){
            if(dp[n][i]) {
                
                ans = Math.min(ans, sum-2*i);
            }
        }
        
        return ans;
    }
    
    void bottomup(int[] arr, int sum, int n, boolean[][] dp){
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=sum; j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
    }
}
