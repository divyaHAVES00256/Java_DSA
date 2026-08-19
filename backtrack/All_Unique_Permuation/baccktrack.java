package All_Unique_Permuation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class baccktrack {
    private static ArrayList<String> ans;

    static ArrayList<String> findPermutation(String s) {
        ans = new ArrayList<>();

        //we used the stringbuilder -> thid id mutable
        //hnec the backtrack is required
        StringBuilder sb = new StringBuilder(s);
        back(0, sb);

        Collections.sort(ans);
        return ans;
    }

    static void back(int idx, StringBuilder ip) {
        if (idx == ip.length()-1) {
            ans.add(ip.toString());
            return;
        }

        // Tracks characters already used at this recursion level
        HashSet<Character> used = new HashSet<>();

        for (int i = idx; i < ip.length(); i++) {
            char ch = ip.charAt(i);

            // Skip duplicate choices for the current position
            if (used.contains(ch)) {
                continue;
            }

            used.add(ch);

            // Swap
            char temp = ip.charAt(i);
            ip.setCharAt(i, ip.charAt(idx));
            ip.setCharAt(idx, temp);

            // Recurse
            back(idx + 1, ip);

            // Backtrack
            temp = ip.charAt(i);
            ip.setCharAt(i, ip.charAt(idx));
            ip.setCharAt(idx, temp);
        }
    }
}
