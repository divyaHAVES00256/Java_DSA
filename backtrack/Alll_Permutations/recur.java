import java.util.ArrayList;
import java.util.Collections;

public class recur{
    //recurion where duplicates are allowed
    //here we are doing the pass vy value(as the string in the params is pass by value)
    static ArrayList<String> ans;

    static ArrayList<String> findPermutation(String s) {
        ans = new ArrayList<>();

        recur("", s);

        Collections.sort(ans);
        return ans;
    }

    static void recur(String op, String ip) {
        if (ip.length() == 0) {
            ans.add(op);
            return;
        }

        for (int i = 0; i < ip.length(); i++) {
            //add character
            char ch = ip.charAt(i);
            
            //remove character
            String newIp =
                    ip.substring(0, i) +
                    ip.substring(i + 1);

            //recursion
            recur(op + ch, newIp);
        }
    }
}