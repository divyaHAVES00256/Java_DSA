// import java.util.Arrays;
// import java.util.Comparator;
import java.util.PriorityQueue;

public class ConnectRopes {
    // static class Ropes implements Comparable<Ropes> {
    //     int l;

    //     public Ropes(int l){
    //         this.l = l;
    //     }

    //     @Override
    //     public int comapreTo(Ropes r){
    //         return this.l - r.l;
    //     }
    // }
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 6};
        // int[] arr = {2, 3, 3, 6, 4};


        // Arrays.sort(arr);
        // int sum = arr[0];
        // int res = 0;

        // for (int i = 1; i < arr.length; i++) {
        //     sum += arr[i];   
        //     res += sum;      
        //     System.out.println(res + "Intermediate sum: " + sum);
        // }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i<arr.length; i++) {
            pq.add(arr[i]);
        }

        int sum = 0;
        // int res = 0;
        while(pq.size()>1){
            int a = pq.poll();
            int b = pq.poll();
            int s = a+b;

            pq.add(s);

            sum+=s;

            System.out.println(sum);
        }
    }
}
