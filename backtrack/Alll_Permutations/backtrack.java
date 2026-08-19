import java.util.ArrayList;
import java.util.Collections;

public class backtrack {
    ArrayList<String> ans;
    public ArrayList<String> permutation(String s) {
        //String is immutable -> pass by val
        ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        back(0, sb);
        
        Collections.sort(ans);
        
        return ans;
    }
    
    void back(int idx, StringBuilder ip){
        if(idx == ip.length()-1){
            ans.add(ip.toString());
            return;
        }
        
        for(int i = idx; i<ip.length(); i++){
            //swap
            char temp = ip.charAt(i);
            ip.setCharAt(i, ip.charAt(idx));
            ip.setCharAt(idx, temp);
            
            //recur
            back(idx+1, ip);
            
            //acktrack
            char temp2 = ip.charAt(i);
            ip.setCharAt(i, ip.charAt(idx));
            ip.setCharAt(idx, temp2);
        }
        
        
    }
}
