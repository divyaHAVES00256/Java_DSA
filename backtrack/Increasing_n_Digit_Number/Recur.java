package Increasing_n_Digit_Number;

import java.util.ArrayList;

public class Recur {
    //next digit is current_i + 1 to n choices
    //time:  $O(9Cn)$
    static private ArrayList<Integer> ans;

    public static ArrayList<Integer> increasingNumbers(int n) {
        ans = new ArrayList<>();
        
        // Base case for 1 digit
        if (n == 1) {
            for (int i = 0; i <= 9; i++) ans.add(i);
            return ans;
        }
        
        // Edge case: It's impossible to have strictly increasing numbers longer than 9 digits 
        // (digits 1 through 9 only have 9 available spots)
        if (n > 9) {
            return ans;
        }
        
        find(0, 0, 1, n);
        return ans;
    }

    // num    : The integer built so far
    // length : How many digits we have added
    // start  : The minimum digit we are allowed to use next
    static void find(int num, int length, int start, int n) {
        if (length == n) {
            ans.add(num);
            return;
        }

        for (int i = start; i <= 9; i++) {
            find(num * 10 + i, length + 1, i + 1, n);
        }
    }
}
