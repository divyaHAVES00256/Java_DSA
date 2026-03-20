import java.util.Arrays;
public class Implementaion{
    public int myAtoi(String s) {
        if(s.length()<1) return 0;
        StringBuilder sb = new StringBuilder();
        //leading spaces
        int i = 0;
        while(i<s.length() && s.charAt(i)==' '){
            i++;
        }
        
        while(i<s.length()){
            sb.append(s.charAt(i));
            i++;
        }
        if(sb.length()<1) return 0;
        // System.out.println(sb);

        //find sign
        int ans = 0;

        char []arr = sb.toString().toCharArray();
        int si = 0;
        int sign = 1;
        while(si<arr.length && !Character.isDigit(arr[si])) {
            if(arr[si] == '-')sign = -1;
            si++;
        }

        //handle charcater
        // System.out.println(sign);
        for(int j = 0; j<arr.length; j++){
            if((Character.isLetter(arr[j]) || arr[j]=='.')) break;
            if(j>0 && (arr[j]=='+' || arr[j]=='-') || arr[j]==' ') break;

            if(Character.isDigit(arr[j])) {
                int dig = arr[j] - '0';ans > 214748364
                //check overflow condtion before updating the ans
                if(ans>Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE / 10 && dig > 7)){
                    if(sign<0) return -2147483648;
                    else return 2147483647;
                }
                ans = ans*10+dig;
            }
        }
       

        return ans*sign;
    }
    public static void main(String[] args){
        System.out.println(Atoi(" -   12345" ));
        System.out.println(Atoi("+ 001203"));
        System.out.println(Atoi("0-1"));
    }
}