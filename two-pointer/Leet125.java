import java.util.ArrayList;

public class Leet125 {
    public boolean isPalindrome(String s) {
       
        s = s.toLowerCase();
        ArrayList<Character> arr = new ArrayList<>();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLetter(c) || Character.isDigit(c))arr.add(c);
        }
        int l = 0, r = arr.size()-1;
        while(l<r){
            char lef = arr.get(l);
            char rig = arr.get(r);


            if(lef!=rig) return false;
            l++;
            r--;
        }
        return true;
    }

    public boolean isPalindrome2(String s) {

        s = s.toLowerCase();
        String a = s.replaceAll("[^a-zA-Z0-9]", "");
        int l = 0, r = a.length()-1;
        while(l<r){
            char lef = a.charAt(l);
            char rig = a.charAt(r);


            if(lef!=rig) return false;
            l++;
            r--;
        }
        return true;
    }
}