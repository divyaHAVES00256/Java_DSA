import java.util.Stack;
//tc, sc = n
public class PostfixToInfix {

    static String postToInfix(String exp) {

        Stack<StringBuilder> st = new Stack<>();

        //left to right 
        for (char c : exp.toCharArray()) {
            // Operand
            if (Character.isLetterOrDigit(c)) {
                st.push(new StringBuilder().append(c));
            }

            // Operator
            else {
                StringBuilder s1 = st.pop();
                StringBuilder s2 = st.pop();

                StringBuilder curr = new StringBuilder();
                //(, s2, c, s1, )
                curr.append('(')
                    .append(s2)
                    .append(c)
                    .append(s1)
                    .append(')');

                st.push(curr);
            }
        }

        return st.pop().toString();
    }

    public static void main(String[] args) {

        String exp = "ab+c*";

        System.out.println(postToInfix(exp));
    }
}

/*
Traverse the postfix expression from left to right.
Use a stack to store operands.
For each operator, pop two operands, combine them in infix order with parentheses, and push the result back.
The final item in the stack will be the infix expression.
*/

