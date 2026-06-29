package longest_common_substring;

public class Memoization {
    Integer[][][] dp;

    public int longCommSubstr(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        dp = new Integer[n + 1][m + 1][Math.min(n, m) + 1];
        return solve(s1, s2, n, m, 0);
    }

    int solve(String s1, String s2, int i, int j, int count) {
        if (i == 0 || j == 0) return count;

        if (dp[i][j][count] != null) return dp[i][j][count];

        int same = count;

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            same = solve(s1, s2, i - 1, j - 1, count + 1);
        }

        int skip1 = solve(s1, s2, i - 1, j, 0);
        int skip2 = solve(s1, s2, i, j - 1, 0);

        return dp[i][j][count] = Math.max(same, Math.max(skip1, skip2));
    }
}
