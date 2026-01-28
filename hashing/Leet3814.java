import java.util.*;
public class Leet3814{
     public void maxCapacity(int[] costs, int[] capacity, int budget) {
        int[][] make = new int[costs.length][2];

        for(int i = 0; i<costs.length; i++){
            make[i][0] = costs[i];
            make[i][1] = capacity[i];
        }
        Arrays.sort(make, (a, b) -> Integer.compare(a[0], b[0]));
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i<costs.length; i++){
            for(int j = i; j<costs.length; j++){
                int sum = 0;
                int cap = 0;
                if (i!=j) {
                    sum+=make[j][0]+make[i][0];
                    cap += make[j][1]+make[i][1];
                }
                else  {
                    sum+=sum+=make[j][0];
                    cap += make[j][1];
                }
                
                
                if(sum<budget){
                    ans = Math.max(ans, cap);
                }

                // System.out.println(i + " " + j);
            }

        }
    }
    public static void main(String [] args) {

    }
}