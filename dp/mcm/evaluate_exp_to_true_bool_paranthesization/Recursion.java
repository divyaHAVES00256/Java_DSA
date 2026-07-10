package evaluate_exp_to_true_bool_paranthesization;

public class Recursion {
    //tc: 4^n
    //sc: n
    //intution was
    //rather than calculating the true, false by breaking down the string
    //we count how many ways the expressoon becoms true and false using mcm logic
    static int countWays(String s) {
        // The last parameter isTrue represents the value 
        // you want the current subexpression to evaluate to.
        boolean istrue = true;
        
        return find(s.toCharArray(), 0, s.length()-1, istrue);
    }
    
    //string, boundary(i, j), what we want
    static int find(char[] s, int i, int j, boolean istrue){
        //base
        if(i>j) return 0;
        if(i == j){
            //if we have same value as what we want in istrue
            //return true 
            if(istrue){
                if(s[i] == 'T') return 1;
                else return 0;
            } else {
                if(s[i] == 'F') return 1;
                else return 0;
            }
        }
        
        int ans = 0;
        
        //split on operators only
        for(int k = i+1; k<=j-1; k+=2){
            //what are the choices
            // We want the left expression to evaluate to false.
            // Passing false means we are counting the ways the left subexpression becomes false.
            int lf = find(s, i, k - 1, false);
            
            // We want the left expression to evaluate to true.
            // Passing true means we are counting the ways the left subexpression becomes true.
            int lt = find(s, i, k - 1, true);
            
            // We want the right expression to evaluate to false.
            // Passing false means we are counting the ways the right subexpression becomes false.
            int rf = find(s, k + 1, j, false);
            
            // We want the right expression to evaluate to true.
            // Passing true means we are counting the ways the right subexpression becomes true.
            int rt = find(s, k + 1, j, true);
            
            if(s[k] == '|'){
                //curr exp is true
                if(istrue){
                    //add how many ways it becomes true
                    ans += (lt*rt + lt*rf + lf*rt);
                }
                //curr exp is false
                else {
                    //how many ways it returns false
                    ans += (lf*rf);
                }
            } else if(s[k] == '&'){
                if(istrue){
                    ans += (lt*rt);
                } else {
                    ans += (lf*rf + lt*rf + lf*rt);
                }
            } else if(s[k] == '^') {
                if(istrue){
                    ans += (lf*rt + lt*rf);
                } else {
                    ans += (lt*rt + lf*rf);
                }
            }
        }
        
        return ans;
    }
}
