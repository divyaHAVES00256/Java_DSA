package shortest_common_SuperSequence;

public class BottomUp {
    //shrtest common subsequnce length -> (n+m)-l
    //String a -> len n
    //String b -> len m
    //LCS len -> len l

    //now how to print this supersequence?
    /*
    1) find lcs
    2) start from the end of the dp
    3) a-> If chars match → take once
    3) b-> If chars differ → move in direction of larger LCS
    4) Append leftovers
    5) Reverse at end
     */

    public String shortestCommonSupersequence(String a, String b) {
        //find longest common subsequence
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n+1][m+1];

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        //length of supersequence
        System.out.println((n+m)-dp[n][m]);

        //find supersequnce
        StringBuilder sb = new StringBuilder();
        while(m>0 && n>0){
            if(a.charAt(n-1) == b.charAt(m-1)){
                sb.append(a.charAt(n-1));
                n--; m--;
            } else {
                // If skipping b[m-1] preserves more LCS,
                // include b[m-1] in SCS and move left
                if(dp[n][m-1] > dp[n-1][m]){
                    sb.append(b.charAt(m-1));
                    m--;
                }

                // Otherwise skip a[n-1],
                // include a[n-1] in SCS and move up
                else{
                    sb.append(a.charAt(n-1));
                    n--;
                }
            }
        }
        //add remaining
        while(n > 0){
            sb.append(a.charAt(n-1));
            n--;
        }

        while(m > 0){
            sb.append(b.charAt(m-1));
            m--;
        }
        return sb.reverse().toString();
    }
}
