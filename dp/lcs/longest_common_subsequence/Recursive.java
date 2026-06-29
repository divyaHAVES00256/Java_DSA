package longest_common_subsequence;
public class Recursive {
    //evry charahter has the choice of taken or not taken
    //time = 2^min(n+m);
    //space = min(n, m)
    public int longestCommonSubsequence(String x, String y) {
        int n = x.length();
        int m = y.length();
        return recur(x, y, n, m);
    }

    int recur(String x, String y, int n, int m){
        // System.out.println(n +" " + m);
        // System.out.println(x +" " + y);
        //base
        //striing is empty
        if(n == 0 || m == 0){
            return 0;
        }

        //choice diagram
        //last char is equal
        if(x.charAt(n-1) == y.charAt(m-1)){
            return recur(x, y, n-1, m-1)+1;
        } 
        //kast char not equal
        //return max
        else {
            return Math.max(recur(x, y, n, m-1), recur(x, y, n-1, m));
        }
    }
}
