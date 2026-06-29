package longest_common_substring;

public class Recursion {
    //brute force
    //check substring formed for every i, j
    //return max out of all
    //time: (n*m) * min(n, m)
    //space: min(n, m)
    public int longCommSubstr(String x, String y) {
        // code here
        int n = x.length();
        int m = y.length();
        
       int ans = 0;
       
       for(int i = 1; i<=n; i++){ //n*m
           for(int j =1; j<=m; j++){
               ans = Math.max(ans, recur(x, y, i , j));
           }
       }
       return ans;
    }
    int recur(String x, String y, int n, int m){ //min(n, m)
        // System.out.println(n + " " + m);
        //base -> empty string
        if(n == 0 || m == 0){
            return 0;
        }
        
        //equal
        if(x.charAt(n-1) == y.charAt(m-1)){
            return recur(x, y, n-1, m-1)+1;
        }
        //not euqla -> breaks the substring -> here recurstion will be stopped
        else {
            return 0;
        }
    }
}
