//extended of subset sum
//count how many subsets equals to target k
//tc = n*k
//sc = n*k
public class BottomUp {
     public int perfectSum(int[] arr, int k) {

        int n = arr.length;
        int[][] dp = new int[n + 1][k + 1];

        // Base case:
        // There is 1 way to make sum 0 -> pick nothing
        //but what is the arr contain elemnt 0 as well?
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 0; j <= k; j++) {

                if (arr[i - 1] <= j) {
                    // dont pick/pick5
                    dp[i][j] =
                        dp[i - 1][j] +
                        dp[i - 1][j - arr[i - 1]];

                } else {
                    //cant pick
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][k];
    }
}
