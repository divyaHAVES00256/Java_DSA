// import java.util.Arrays;
// import java.util.Comparator;
import java.util.PriorityQueue;

public class ConnectRopes {
    public static void main(String[] args) {
        // int[] arr = {4, 3, 2, 6};
        int[] arr = { 4, 3, 3, 2, 6 };
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i<arr.length; i++) pq.add(arr[i]);
        
        int ans = 0;

        while(pq.size()>1) {
            int a = pq.poll();
            int b = pq.poll();

            int sum = a+b;

            ans += sum;

            System.out.println(ans + "  ans : sum " + sum);

            pq.add(sum);
        }
    }
}
