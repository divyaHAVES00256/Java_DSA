
import java.util.HashMap;
import java.util.HashSet;
public class Leet3 {
    public static void lengthOfLongestSubstring2(String s) { //n^3
        int ans = 0;
        // String res = "";
        for(int i = 0; i<s.length(); i++) { //n
            HashMap<Character, Integer> map = new HashMap<>(); //n
            for(int j = i; j<s.length(); j++) {  //n
                String st = s.substring(i, j+1);
                // System.out.println("JBzNBJXB");
                // System.out.println(st);
                for(int k = 0; k<st.length(); k++) { //n
                    map.put(st.charAt(k), map.getOrDefault(st.charAt(k), 0)+1);
                }

                if(map.size() == st.length()) {
                    ans = Math.max(ans, st.length());
                    System.out.println(st + " " + ans);
                }
            }
        }
        System.out.println(ans);
    }

    //optimal using two pointer
    public int lengthOfLongestSubstring(String s) { //tc:2n and sc:1 //tc goes to 2n when all elements are same
        int l = 0;
        int r = 0;
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while(r<s.length()){
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0)+1);

            int max = r-l+1;

            if(map.size()<max){
                int freqr = map.get(s.charAt(r));
                freqr--;
                if(freqr<=0) map.remove(s.charAt(r)); //remove if 0 freq
                else map.put(s.charAt(r), freqr);

                int freql = map.get(s.charAt(l));
                freql--;
                if(freql<=0) map.remove(s.charAt(l)); //remove if 0 freq
                else map.put(s.charAt(l), freql);

                l++;
            }

            else {
                ans = Math.max(ans, max);
                r++;
            }

            // System.out.println(map + " " + ans + " " + c);
            // System.out.println(ans + " " + c);
        }

        return ans;
    }

    public static int lengthOfLongestSubstring3(String s) {
        int l = 0;
        int r = 0;
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while(r<s.length()){
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0)+1);

            while(map.get(c)>1){ //this will take the l to next to duplicate causing element
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                l++;
            }
            int max = r-l+1;

            ans = Math.max(ans, max);
            r++;
        }

        return ans;


        // HashSet<Character> set = new HashSet<>();
        // int l = 0, r = 0, ans = 0;

        // while (r < s.length()) {
        //     char c = s.charAt(r);

        //     while (set.contains(c)) {
        //         set.remove(s.charAt(l));
        //         l++;
        //     }

        //     set.add(c);
        //     ans = Math.max(ans, r - l + 1);
        //     r++;
        // }

        // return ans;
    }
    public static void main(String[] args) {
        String text = "hello yy world";
        String pattern = "world";

        int index = text.indexOf(pattern);

        // if (index != -1) {
        //     System.out.println("Found at index: " + index);
        // } else {
        //     System.out.println("Not found");
        // }

        // lengthOfLongestSubstring("pwwkewkr");
        // lengthOfLongestSubstring("abc");


    }
}