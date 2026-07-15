package egg_dropping_problem;

import java.util.Arrays;

public class Memoization {
    // time : e*f * f
    //number of states(e to f) = e*f
    // work state (1 to f) = f
    // space : e*f

    
    int dp[][];
    public int superEggDrop(int e, int f) {
        dp = new int[e+1][f+1];
        for(int i = 0; i<=e; i++){
            Arrays.fill(dp[i], -1);
        }
        return memo(e, f);
    }

    int memo(int e, int f){
        if(f == 0) return 0;
        if(f == 1) return 1;
        if(e == 1) return f;

        if(dp[e][f]!=-1) return dp[e][f];
        int min = Integer.MAX_VALUE;
        for(int k = 1; k<=f; k++){
            // Testing dropping from floor k
            int temp = 1; // 1 attempt for the current drop

            // Math.max: We assume the worst-case outcome between breaking and surviving
            // If broken: we lost an egg, and we only need to check the (k-1) floors BELOW k.
            // If survived: we kept the egg, and we only need to check the (f-k) floors ABOVE k.
            temp += Math.max(memo(e-1, k-1), memo(e, f-k));

            // Math.min: Out of all the floors 'k' we could have started from, which one gave us the smallest worst-case?
            min = Math.min(temp, min);
        }
        dp[e][f] = min;

        return min;
    }
}
