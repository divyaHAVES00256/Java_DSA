import java.util.Stack;
//tc, sc = n
public class PrefixToInfix {
    // User function Template for Java

    static String preToInfix(String e) {
        Stack<String> st = new Stack<>();
        
        int n = e.length();
        
        //right to left
        for(int i = n-1; i>=0; i--){
            char c = e.charAt(i);
            
            if(Character.isLetterOrDigit(c)){
                st.push(String.valueOf(c));
            }
            
            else{
                //(, s1, c, s2, )
                st.push('('+st.pop()+c+st.pop()+')');
                
            }
        }
        
        return st.pop();
    }

}
/*
Traverse the prefix expression from right to left.
Use a stack to store operands.
For each operator, pop two operands from the stack, wrap them in parentheses, and push the resulting expression back.
The final item in the stack will be the infix expression.
*/