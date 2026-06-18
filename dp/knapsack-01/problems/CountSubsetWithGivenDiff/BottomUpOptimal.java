package problems.CountSubsetWithGivenDiff;

public class BottomUpOptimal {
    //1) i1 = target  = (sum+diff)/2
    //2) this i1 is the subset1 summation
    //3) if we can find how mnay ways i1 can be formed we can also find the diffrence count
    public static int countsubset(int[] arr, int diff){
        int sum = 0;
        for(int i : arr){
            sum+=i;
        }
        // If sum - diff is odd, or diff > sum, it's impossible to partition
        if ((sum - diff) < 0 || (sum - diff) % 2 != 0) {
            return 0;
        }

        //1) Target
        int n = arr.length;
        int target = (sum + diff)/2;

        //2)  Initialize ONLY dp[0][0] = 1. Let the loop handle the 0s in the array
        int dp[][] = new int[n+1][target + 1];
        dp[0][0] = 1;

        //3) Count Subset with given target
        bottomup(arr, n, target, dp);

        //4) Return count
        return dp[n][target];
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
        int arr[] = {2};
        int diff = 2;

        System.out.println(countsubset(arr, diff));
    }
}
