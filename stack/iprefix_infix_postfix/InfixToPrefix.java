import java.util.*;
// tc = 2n (insert and delte)
//sc = n+n (sb + stack)
public class InfixToPrefix {
     public String infixToPrefix(String s) {
        // code here

        //REVERSE
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                sb.setCharAt(i, ')');
            } 
            else if (sb.charAt(i) == ')') {
                sb.setCharAt(i, '(');
            }
        }
        
        //TO POSTFIX
        StringBuilder ans = infixToPostfix( sb.toString());
        
        //REVERSE
        ans.reverse();
        
        //PREFIX
        return ans.toString();
        
    }
    
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
    
    public static StringBuilder infixToPostfix(String s) {
        // code here
        StringBuilder sb = new StringBuilder(); // operand
        
        Stack<Character> st  = new Stack<>();
        st.push('(');
        
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
                    //this right associtivity and left left associativity prefrences changes here
                    //why?
                    if(c == '^'){
                        while(!st.isEmpty() && st.peek()!='(' && prec(st.peek())>=prec(c) ){
                            sb.append(st.pop());
                        }
                    } else {
                        while(!st.isEmpty() && st.peek()!='(' && prec(st.peek())>prec(c) ){
                            sb.append(st.pop());
                        }
                    }
                   
                    
                    st.push(c);
                }
            }
        }
        
        while(!st.isEmpty() && st.peek()!='('){
            sb.append(st.pop());
        }
        
        return sb;
    }
}

/*IMPORTANT NOTE
# Infix → Prefix Algorithm

1. Reverse the infix expression
2. Swap `(` and `)`
3. Convert modified expression to postfix
4. Reverse postfix expression → Prefix

---

# Associativity Notes

## Infix → Postfix

* `^` is Right Associative → use `>`
* `+,-,*,/` are Left Associative → use `>=`

---

## Infix → Prefix

Expression is reversed first, so associativity behavior also reverses.

* `^` → use `>=`
* `+,-,*,/` → use `>`

---

# Memory Trick

Reversing the expression reverses associativity behavior.
*/

