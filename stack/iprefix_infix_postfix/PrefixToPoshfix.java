import java.util.Stack;
//tc sc: n
public class PrefixToPoshfix {
    static String preToPost(String s) {
        // code here
        Stack<String> st = new Stack<>();
        int n = s.length();
        
        //right to left
        for(int i = n-1; i>=0; i--){
            char c = s.charAt(i);
            
             //operand c : push
            if(Character.isLetterOrDigit(c)){
                st.push(String.valueOf(c));
            } else {
                
                //operator -> perform operation
                //s1, s2, c
                String s1 = st.pop();
                String s2 = st.pop();
                st.push(s1+s2+c);
            }
        }
        
        return st.pop();
        
        
    }
}

/*
Traverse the prefix expression from right to left.
Use a stack to store operands.
For each operator, pop two operands from the stack, combine them with the operator, and push the result back.
The final item in the stack will be the postfix expression.
*/
