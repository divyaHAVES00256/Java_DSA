package problems.CountSubsetWithGivenDiff;
import java.util.*;
public class Memoization {
     public static int countsubset(int[] arr, int diff){
        int sum = 0;
        for(int i : arr){
            sum+=i;
        }
        //Edge Case: If sum - diff is odd, or diff > sum, it's impossible to partition
        if ((sum - diff) < 0 || (sum - diff) % 2 != 0) {
            return 0;
        }

        //1) Target
        int n = arr.length;
        int target = (sum + diff)/2;

        //2)  Initialize ONLY dp[0][0] = 1. Let the loop handle the 0s in the array
        int dp[][] = new int[n+1][target + 1];
        for(int i = 0; i<=n; i++){
            Arrays.fill(dp[i], -1);
        }

        //3) Count Subset with given target
        memoization(arr, n, target, dp);

        //4) Return count
        return dp[n][target];
    }
    static int memoization(int arr[], int n, int s, int[][] dp){
    //    if (n == 0) {
    //         if (s == 0) return 1; // Valid subset found
    //         return 0;             // Invalid subset
    //     }

        if(n == 0 && s == 0) return 1;
        // if(s == 0) return 1; //this leads to premature stop -> when the array contains 0
        if(n == 0) return 0;

        if(dp[n][s] != -1) return dp[n][s];

        if(arr[n-1]<=s){
            dp[n][s] = memoization(arr, n-1, s-arr[n-1], dp) + memoization(arr, n-1, s, dp);
        } else {
            dp[n][s] = memoization(arr, n-1, s, dp);
        }

        return dp[n][s];
    }

    public static void main(String[] args) {
        int arr[] = {0};
        int diff = 0;

        System.out.println(countsubset(arr, diff));
    }
}
