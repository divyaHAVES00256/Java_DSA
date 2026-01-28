import java.util.HashMap;
public class Leet76 {
    //brute force tc=n*n*m, sc=1
    public static void minWindow(String s, String t) {
        if(s.length()<t.length()) return;
        int ans = s.length();
        String res = "";
        int minLen = Integer.MAX_VALUE;
        
        for(int i = 0; i<s.length(); i++) { //n
            for(int j = i; j<s.length(); j++){ //n
                //form a substring
                String sub  = s.substring(i, j+1);
                System.out.println(sub);

                //check if the t has all the elements in the str
                if (containsAll(sub, t)) {
                    if (sub.length() < minLen) {
                        minLen = sub.length();
                        res = sub;
                    }
                }
            }
        }

        System.out.println(res + " ans " + ans);
    }
    private static boolean containsAll(String sub, String t) {
        int[] freq = new int[128];

        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        for (char c : sub.toCharArray()) {
            freq[c]--;
        }

        for (int count : freq) {
            if (count > 0) return false;
        }
        return true;
    }
    
    //optimized tc=n+m sc=t
    //two pinters + hashmap + sliding window
    public static String minWindow2(String s, String t) {
        if(s.length()<t.length()) return "";

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        int l= 0, r = 0;
        int count = t.length();
        int minlen = Integer.MAX_VALUE;

        int start_l = 0;
        
        while(r<s.length()){ //2n(add+remove only once)
            //get curr
            char c = s.charAt(r);

            //is the map curr is less than 1-> count dec
            if(map.containsKey(c) && map.get(c)>0) count--;
            //is it in the map->freq dec means char found
            if(map.containsKey(c))map.put(c, map.get(c)-1);

            //is count 0-> all chars found
            while(count==0){
                //update ans
                if(r-l+1<minlen){
                    minlen = r-l+1;
                    start_l = l; //we need this bc while returning result string we need the exact left pointer
                }

                //inc l char freq means remiving from the map
                char rem = s.charAt(l);

                if(map.containsKey(rem)) map.put(rem, map.get(rem)+1);

                //count is incremnted when freq is greater than 0 means we are needed this char
                if (map.containsKey(rem) && map.get(rem)>0) count++;

                l++;

            }
            r++;
            
        }
        
        return minlen == Integer.MAX_VALUE ? "" : s.substring(start_l, start_l + minlen);
    }
    public static void main(String[] args) {
        String text = "AD";
        String pattern = "ABC";

        int index = text.indexOf(pattern);

        if (index != -1) {
            System.out.println("Found at index: " + index);
        } else {
            System.out.println("Not found");
        }

        minWindow(text, pattern);
    }
}

