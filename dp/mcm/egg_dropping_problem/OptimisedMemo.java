package egg_dropping_problem;

import java.util.Arrays;

public class OptimisedMemo {
    //if i look carefully -> it has the resumples of binary serach

    //solving using mcm intution -> chck every floor 
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
            int temp = 1; // 1 attempt for the current drop

            int broken; //low -> monotonically increasing? why? as k increases the number of floor below k increses, why?
            if(dp[e-1][k-1]!=-1) broken = dp[e-1][k-1];
            else broken = memo(e-1, k-1);

            int surv; //high -> monotonically decresing? why? as k increases the number of floor above k decreses, why?
            if(dp[e][f-k]!=-1) surv = dp[e][f-k];
            else surv = memo(e, f-k);

            temp += Math.max(broken, surv);

            min = Math.min(temp, min);
        }
        dp[e][f] = min;

        return min;
    }
}
