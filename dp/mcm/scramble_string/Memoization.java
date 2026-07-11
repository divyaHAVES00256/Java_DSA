import java.util.HashMap;
import java.util.Map;

public class Memoization {
    //tc: n^4 (worst -> n^5 due to string slicing)
    //sc n^3 + n (map + stack)
    
    Map<String, Boolean> dp;
    public boolean isScramble(String a, String b) {
        //edge cases
        if(a.length()!=b.length()) return false;
        if(a.length() == 0 || b.length() == 0) return false;

        int n = a.length();

        //intialize dp
        //our dp conatins every scramled string 
        //alongside it, 
        //it also tells if current scarmled is correct (true) or not correct (false) 
        dp = new HashMap<>();

        return recur(a, b);
    }


    boolean recur(String a, String b){
        if(a.equals(b)) return true; 

        String s = a + " " + b; //this will be our key 
        if(dp.containsKey(s)) return dp.get(s);
        
        boolean flag = false;

        int n = a.length();

        for(int k = 1; k<=n-1; k++){
            boolean one = recur(a.substring(0, k), b.substring(0, k)) && recur(a.substring(k, n), b.substring(k, n));

            boolean two = recur(a.substring(0, k), b.substring(n-k, n)) && recur(a.substring(k, n), b.substring(0, n-k));

            if(one || two) {
                flag = true;
                break;
            }
        }

        dp.put(s, flag);

        return flag;
    }
}
