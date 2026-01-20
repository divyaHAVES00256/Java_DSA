public class Leet76 {
    public static void minWindow(String s, String t) {
        if(s.length()<t.length()) return;
        int ans = s.length();
        String res = "";

        
        for(int i = 0; i<s.length(); i++) { //n
            for(int j = i; j<s.length(); j++){ //n
                //form a substring
                String str = s.substring(i, j+1);
                System.out.println(str);
                boolean chk = true;

                //check if the t has all the elements in the str
                for(int k = 0; k<t.length(); k++){ //m
                    char c = t.charAt(k);
                    if(str.indexOf(c)==-1){
                        chk = false;
                        break;
                    }
                }

                //if true and length is less than the ans
                if(chk && str.length()<ans){
                    ans = str.length();
                    res = str;
                }
            }
        }

        System.out.println(res + " ans " + ans);
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

