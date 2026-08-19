// package letter-combination-of-a-phone-number;

import java.util.ArrayList;
import java.util.List;

public class Recursion {
    String[] arr;
    List<String> ans;
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        
        arr = new String[]{
            " ",
            " ",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };

        find(0, "", digits);

        return ans;
    }

    void find(int idx, String op, String digits){
        if(idx == digits.length()){
            ans.add(op);
            return;
        }
        String temp = arr[digits.charAt(idx)-'0'];
        for(int i = 0; i<temp.length(); i++){
            find(idx+1, op+temp.charAt(i), digits);
        }
    }
}
