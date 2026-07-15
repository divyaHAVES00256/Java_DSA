public class Recusrion {
    //tc: 4^n
    //sc n*m
    //using mcm intution
    //we will have two way of split and checking the sramples
    //split at index k ->
    //case 1) check swapped 
    //case 2) chcek without swapped
    public boolean isScramble(String a, String b) {
        if(a.length()!=b.length()) return false;
        if(a.length() == 0 || b.length() == 0) return false;

        int n = a.length();

        return recur(a, b);
    }


    boolean recur(String a, String b){
        if(a.equals(b)) return true; //if alreday equla- > return -> no further split requre
        
        boolean flag = false; //tells whether the current substrings are scrambled or not
        int n = a.length();
        for(int k = 1; k<=n-1; k++){
            //case 1 -> no swap (left to left and right to right)
            //abcde
            //k = 1
            //a a
            //bcde bcde

            //we are splitting at k
            //where k is boundary for left part (henece it is exclusive)
            boolean one = recur(a.substring(0, k), b.substring(0, k)) && recur(a.substring(k, n), b.substring(k, n));

            //case 2 -> swapping checked (left to right and right to left)
            //abcde
            //k = 1
            //a e
            //bcde abcd
            boolean two = recur(a.substring(0, k), b.substring(n-k, n)) && recur(a.substring(k, n), b.substring(0, n-k));

            if(one || two) {
                flag = true;
                break;
            }
        }

        return flag;
    }
}
