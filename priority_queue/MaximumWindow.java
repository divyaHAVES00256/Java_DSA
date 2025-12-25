// class Solution {
//     class Max implements Comparable<Max>{
//         int num;
//         int idx;
//         Max (int num, int idx) {
//             this.num = num;
//             this.idx = idx;
//         }

//         @Override
//         public int compareTo(Max m) {
//             return this.num - m.num;
//         }
//     }
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int[] ans = new int[nums.length-k+1];
//         PriorityQueue<Max>  pq =  new PriorityQueue<>(Comparator.reverseOrder());
//         int i = 0;
//         while(i<k){
//             pq.add(new Max(nums[i], i));
//             i++;
//         }
//         ans[0] = pq.peek().num;
//         // int max = ans[]

//         i = 1;
//         for(int j = k; j<nums.length; j++) {
//             int curr = nums[j];

//             //add curr
//             pq.add(new Max(curr, j));

//             //while top is out of window remove
//             while(!pq.isEmpty() && pq.peek().idx <= j-k) pq.poll();

//             //find max
//             ans[i] = pq.peek().num;
//             i++;
//         }
//         // System.out.println(Arrays.toString(ans));
//         return ans;
 
//     }
// }

import java.util.*;
class MaximumWindow {
   
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        Deque<Integer>  dq =  new ArrayDeque<>(); //store idx
        int j = 0;
        for(int i = 0; i<nums.length; i++) {
            //remove out of window from deq
            if(!dq.isEmpty() && dq.peekFirst()==i-k){
                // System.out.println(" out " + dq.pollFirst() ); 
                dq.pollFirst();
            }

            //remove smaller element from deq which are smaller then arr curr
            //this reduces the tc and sc
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                // System.out.println(" last "+ dq.pollLast());
                dq.pollLast();
            }

            //add curr in dq
            dq.offerLast(i);
            // System.out.println("curr dq last " + dq.peekLast());

            //max element into ans when a single window gets completed
            if(i-k>=-1){
                ans[j++] = nums[dq.peekFirst()];
                // System.out.println(Arrays.toString(ans));
            }
                
        }

        // System.out.println(Arrays.toString(ans));
        return ans;
 
    }

    public static void main(String[] args) {
        
    }
}