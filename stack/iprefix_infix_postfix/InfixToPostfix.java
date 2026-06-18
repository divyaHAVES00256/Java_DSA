import java.util.Stack;
//tc = 2n (insert and delte)
//sc = n+n (sb + stack)
public class InfixToPostfix{
//PRECEDNECE 
    public static int prec(char c) {
        if (c == '^')  
            return 3;
        else if (c == '/' || c == '*')  
            return 2;
        else if (c == '+' || c == '-')  
            return 1;
        else
            return -1;
    }
    //IMP:
    //^ is right associative meaning when multiple ^ comes in the exp, we evualte it it simply right to left 
    //other operators behave from left to right for same precedence
    static boolean isRightAssoc(char c){
        return c == '^'; 
    }
    public static String infixToPostfix(String s) {
        // code here
        StringBuilder sb = new StringBuilder(); // operand
        
        Stack<Character> st  = new Stack<>();
        st.push('(');
        
        // String reg = "[a-zA-Z0-9]"
        
        for(char c : s.toCharArray()){
            //operand
            if ((c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9')) {
        
                sb.append(c);
            }
            
            //operators
            else {
                //opening
                if(c =='('){
                    st.push(c);
                }
                //closing
                else if(c == ')'){
                    while(!st.isEmpty() && st.peek()!='('){
                        sb.append(st.pop());
                    }
                    st.pop();
                }
                //lower priority c
                else {
                    //NOTE
                    // Left-to-right associativity → pop existing operator first  (pop)
                    // (+, -, *, /)
                    // Right-to-left associativity → do NOT pop equal precedence (do not pop)
                    // (^)
                    while(!st.isEmpty() && st.peek()!='(' && prec(st.peek())>=prec(c) && !isRightAssoc(c)){
                        sb.append(st.pop());
                    }
                    
                    st.push(c);
                }
                
            }
        }
        
        while(!st.isEmpty() && st.peek()!='('){
            sb.append(st.pop());
        }
        
        
        return sb.toString();
    }
}