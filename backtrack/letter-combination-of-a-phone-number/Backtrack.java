// package letter-combination-of-a-phone-number;

import java.util.ArrayList;
import java.util.List;

public class Backtrack {
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
        StringBuilder sb = new StringBuilder();
        find(0, sb, digits);

        return ans;
    }

    void find(int idx, StringBuilder op, String digits){
        if(idx == digits.length()){
            ans.add(op.toString());
            return;
        }
        String temp = arr[digits.charAt(idx)-'0'];
        for(int i = 0; i<temp.length(); i++){
            op.append(temp.charAt(i));

            find(idx+1, op, digits);

            op.deleteCharAt(op.length()-1);
        }
    }
}
