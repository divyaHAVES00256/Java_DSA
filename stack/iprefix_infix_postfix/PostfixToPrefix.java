import java.util.Stack;

public class PostfixToPrefix {
    static String postToPre(String s) {
        // code here
        Stack<String> st = new Stack<>();
        int n = s.length();
        
        //left to right
        for(char c : s.toCharArray()){
            
            //operand push
            if(Character.isLetterOrDigit(c)){
                st.push(String.valueOf(c));
            } 
            
            //operator
            //perform operation
            //c s2 s1
            else{
            
            
                String s1 = st.pop();
                String s2 = st.pop();
                
                st.push(c+s2+s1);
            }
        }
        
        return st.pop();
    }
}
