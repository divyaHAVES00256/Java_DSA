import java.util.*;

public class Kth_Largest {
    static class KthLargest {
        // tc nlogn, sc k

        private PriorityQueue<Integer> minHeap;
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            minHeap = new PriorityQueue<>();

            for (int num : nums) {
                int n = add(num);
                // System.out.println(n + " peek " + num + " p " + minHeap.peek());
            }
        }

        public int add(int val) {
            minHeap.add(val);

            if (minHeap.size() > k) {// maintain window size k
                minHeap.poll(); // remove smallest
            }
            // System.out.println(minHeap.peek());
            return minHeap.peek(); // kth largest
        }
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 2, 1, 8, 9, -1 };
        KthLargest pq = new KthLargest(4, nums);
        System.out.println(pq.add(3));
        System.out.println(pq.add(5));
        System.out.println(pq.add(10));
        System.out.println(pq.add(9));
        System.out.println(pq.add(4));
    }
}
