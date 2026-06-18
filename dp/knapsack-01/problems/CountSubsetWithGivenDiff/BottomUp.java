package problems.CountSubsetWithGivenDiff;

import java.util.Arrays;

public class BottomUp {
    public static int countsubset(int[] arr, int diff){
        int sum = 0;
        for(int i : arr){
            sum+=i;
        }
        int n = arr.length;
        int dp[][] = new int[n+1][sum/2 + 1];
        System.out.println(n+" "+sum/2);

        for(int i = 0; i<=n; i++){
            for(int j = 0; j<=sum/2; j++){
                if(i == 0) dp[i][j] = 0;
                if(j == 0) dp[i][j] = 1;
            }
        }

        bottomup(arr, n, sum/2, dp);
        
        System.out.println(Arrays.deepToString(dp));

        int ans = 0;
        for(int i = 0; i<=sum/2; i++){
            int d = Math.abs(i - (sum-i));
            System.out.println(i +  " " + dp[n][i] + " " + d);

            //if we look carefully this i = (sum-diff)/2
            //so rather than calculating redundantly for all sum value from 0 to sum/2
            //we only count subsets sum -> from (sum-diff)/2 
            if(diff == Math.abs(i - (sum-i))) ans+= dp[n][i];
        }

        return ans;
    }
    static void bottomup(int arr[], int n, int s, int[][] dp){
        for(int i = 1; i<=n; i++){
            //start j from 0 and not 1 because
            //we can make sum = 0 by not taking any elemnt or taking elemnt value 0
            for(int j = 0; j<=s; j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j - arr[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
                // System.out.println(i + " " + j);
            }

            
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,1,2,3};
        int diff = 1;

        System.out.println(countsubset(arr, diff));
    }
}
