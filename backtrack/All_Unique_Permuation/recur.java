package All_Unique_Permuation;

import java.util.ArrayList;
import java.util.Collections;

public class recur {
    //m1: naive
    //generate all permuation
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
        
        //for each branch we are creatinga a new set to store the anaalyzed chaarcter
        //so that we do not end up adding the same branch again
        int[] used = new int[26];

        for (int i = 0; i < ip.length(); i++) {
            char ch = ip.charAt(i);
            
            //if this character already present -> we do not need that permuation
            if(used[ch-'A'] == 1) continue;
            
            used[ch-'A'] = 1;

            String newIp =
                    ip.substring(0, i) +
                    ip.substring(i + 1);

            recur(op + ch, newIp);
        }
    }


    //m2: in place swapping
    ArrayList<String> ans1;

    public ArrayList<String> permutation(String s) {
        ans = new ArrayList<>();
        back(0, s); // Passing the immutable String directly
        Collections.sort(ans);
        return ans;
    }

    void back(int idx, String ip){
        if(idx == ip.length()-1){
            ans.add(ip);
            return;
        }

        for(int i = idx; i < ip.length(); i++){
            // Create a brand new swapped string.
            // Because 'ip' is immutable, we don't change it. We create 'swapped'.
            String swapped = swap(ip, idx, i);

            // Recurse with the new string
            back(idx + 1, swapped);

            // NO BACKTRACKING NEEDED! 
            // When the loop continues, 'ip' is still exactly what it was 
            // before the recursion, because 'ip' is immutable.
        }
    }

    // Helper method to swap characters and return a NEW string
    String swap(String s, int i, int j) {
        char[] charArray = s.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
