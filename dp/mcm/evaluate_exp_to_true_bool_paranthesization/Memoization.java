package evaluate_exp_to_true_bool_paranthesization;

import java.util.Arrays;

public class Memoization {
    //use 3d dp
    //instead of 3d array -> you can use map
    //map -> key= i+ " " + j + " " + istrue, value = ans
    static int dp[][][];
    static int countWays(String s) {
        // dp[i][j][istrue]
        dp = new int[s.length()+1][s.length()+1][2];
        for(int [][] a : dp){
            for(int[] b : a){
                Arrays.fill(b, -1);
            }
        }
        
        int istrue = 1;
        
        return find(s.toCharArray(), 0, s.length()-1, istrue);
    }
    
    //string, boundary(i, j), what we want
    static int find(char[] s, int i, int j, int istrue){
        //base
        if(i>j) return 0;
        if(i == j){
            //if we have same value as what we want in istrue
            //return true 
            if(istrue == 1){
                if(s[i] == 'T') return 1;
                else return 0;
            } else {
                if(s[i] == 'F') return 1;
                else return 0;
            }
        }
        
        //alrready been analyzed
        if(dp[i][j][istrue]!=-1){
            return dp[i][j][istrue];
        }
        
        int ans = 0;
        
        //split on operators only
        for(int k = i+1; k<=j-1; k+=2){
            //what are the choices
            // We want the left expression to evaluate to false.
            // Passing false means we are counting the ways the left subexpression becomes false.
            int lf = find(s, i, k - 1, 0);
            
            // We want the left expression to evaluate to true.
            // Passing true means we are counting the ways the left subexpression becomes true.
            int lt = find(s, i, k - 1, 1);
            
            // We want the right expression to evaluate to false.
            // Passing false means we are counting the ways the right subexpression becomes false.
            int rf = find(s, k + 1, j, 0);
            
            // We want the right expression to evaluate to true.
            // Passing true means we are counting the ways the right subexpression becomes true.
            int rt = find(s, k + 1, j, 1);
            
            if(s[k] == '|'){
                //curr exp is true
                if(istrue == 1){
                    //add how many ways it becomes true
                    ans += (lt*rt + lt*rf + lf*rt);
                }
                //curr exp is false
                else {
                    //how many ways it returns false
                    ans += (lf*rf);
                }
            } else if(s[k] == '&'){
                if(istrue == 1){
                    ans += (lt*rt);
                } else {
                    ans += (lf*rf + lt*rf + lf*rt);
                }
            } else if(s[k] == '^') {
                if(istrue == 1){
                    ans += (lf*rt + lt*rf);
                } else {
                    ans += (lt*rt + lf*rf);
                }
            }
        }
        
        dp[i][j][istrue] = ans;
        
        return ans;
    }
}
