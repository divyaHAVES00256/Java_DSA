import java.util.Deque;
import java.util.LinkedList;

public class Leet3835 {
    public static void CountSub(int[] nums, int k){
        int count = 0;
        for(int i = 0; i<nums.length; i++){
            for(int j = i; j<nums.length; j++){
                int min = nums[i];
                int max = nums[i];
                for(int l = i; l<=j; l++){
                    min = Math.min(min, nums[l]);
                    max = Math.max(max, nums[l]);

                }
                System.out.println(i + " " + j + " " + min + " " + max);
                if(((max-min)*(j-i+1))<=k) count++;
                else break;
            }
        }

        System.out.println(count);
    }

    public long countSubarrays(int[] nums, long k) {
        //an element is removed and added once in both the deques
        //tc = 2n+2n = n
        // sc = n+n
        Deque<Integer> min = new LinkedList<>();
        Deque<Integer> max = new LinkedList<>();
        
        int l = 0, r = 0;
        long ans = 0;

        while(r<nums.length){
            //min and max processing
            while(!min.isEmpty() && nums[min.peekLast()]>nums[r]) min.pollLast();
            min.addLast(r);

            while(!max.isEmpty() && nums[max.peekLast()]<nums[r]) max.pollLast();
            max.addLast(r);

            //if window become invalid srink window
            // int condition = (nums[max.peekFirst()] - nums[min.peekFirst()])*(r-l+1)
            while(!min.isEmpty() && !max.isEmpty() && (long)(nums[max.peekFirst()] - nums[min.peekFirst()])*(r-l+1)>k) {
               
                if(l==min.peekFirst()) min.pollFirst();
                if(l==max.peekFirst()) max.pollFirst();
                l++;

            }
            // automatically keep adding the valid combination by this trick 
            //if l-r is valid l+1-r(to  r-r) is also a valid subarray-> this helps in calculating number of subarryas
            //here as we can see r-r is also taken so this method counts same index valid subarray implicitly
            
            // Now the window [l..r] is valid and l is the LEFTMOST valid start for r.
            //
            // We fix the right endpoint at r and count how many valid subarrays
            // end exactly at index r.
            //
            // All valid subarrays ending at r are:
            //   [l..r], [l+1..r], [l+2..r], ..., [r..r]
            //
            // Why are all of them valid?
            // - If [l..r] is valid, shrinking the window from the left
            //   can only decrease (max - min) and also decreases the length.
            // - So the cost never increases when moving the start forward.
            //
            // Count of valid subarrays ending at r:
            //   number of possible start positions = r - l + 1
            //
            // IMPORTANT:
            // - Single-element subarrays (i,i) are counted when r == i
                    //
                    // Example:
                    // nums = [1, 3, 2], k = 4
                    //
                    // r = 0:
                    //   valid subarrays ending at r:
                    //   [0..0]  -> single element
                    //   r - l + 1 = 1  -> counts (0,0)
                    //
                    // r = 1:
                    //   valid subarrays ending at r:
                    //   [0..1], [1..1]
                    //   r - l + 1 = 2  -> counts (1,1) here
                    //
                    // r = 2:
                    //   window shrinks to [1..2]
                    //   valid subarrays ending at r:
                    //   [1..2], [2..2]
                    //   r - l + 1 = 2  -> counts (2,2) here
            // - Longer subarrays are counted when r reaches their right end
            // - Each subarray is counted exactly once, no duplicates
            ans+=(long)(r-l+1);
            r++;
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 0, 4};
        // int[] nums = {5,5,5,5};

        CountSub(nums, 4);
    }
}
