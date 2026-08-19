package palindromic_partition;

import java.util.ArrayList;
import java.util.List;

// time: n*2^n
// space: n

//use dp+backtracp to optimize time to n^2
public class backtrack {
    List<List<String>> ans;
    
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        // We only need the starting index and the original string
        find(0, temp, s);
        return ans;
    }

    void find(int st, List<String> temp, String s) {
        // Base case: If our starting index reaches the end of the string,
        // it means we successfully partitioned the whole string.
        if (st == s.length()) {
            ans.add(new ArrayList<>(temp));
            return; // Important: return to stop further execution
        }

        // Try every possible ending index 'i' for the current substring
        for (int i = st; i < s.length(); i++) {
            // Check if substring s[st...i] is a palindrome
            if (ispalin(s, st, i)) {
                // 1. Choose: Add the palindrome to our current path
                temp.add(s.substring(st, i + 1));
                
                // 2. Explore: Partition the REST of the string (i + 1 onwards)
                find(i + 1, temp, s);
                
                // 3. Un-choose (Backtrack): Remove it so we can try the next 'i'
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    // Updated to check directly on the original string using indices
    boolean ispalin(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
