import java.util.Arrays;
import java.util.*;

public class leet169 {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int result = 0;

        // Check all 32 bits of an integer
        for (int i = 0; i < 32; i++) {
            int count = 0;

            for (int num : nums) {
                // Check if ith bit is set
                if (((num >> i) & 1) == 1) {
                    count++;
                }
            }

            // If this bit occurs in more than n/2 numbers
            if (count > n / 2) {
                result |= (1 << i);
            }
        }

        return result;
    }

    public int majorityElement2(int[] nums) {
        int can = nums[0];
        int count = 1;
        for(int i = 1; i<nums.length; i++) {
            if(can == nums[i]) count++;
            else count--;
            // System.out.println(count + " " + nums[i]);
            if(count==0) {can = nums[i]; count = 1;}
        }
        return can;
    }


    // public int majorityElement3(int[] nums) {
    //     HashMap<Integer, Integer> map = new HashMap<>();

    //     for(int i = 0; i<nums.length; i++) {
    //         map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
    //         if(map.get(nums[i])>nums.length/2) {
    //             return nums[i];
    //         }
    //     }
    //     return 0;

    //     // Arrays.sort(nums);
    //     // int n = nums.length;
    //     // return nums[n/2];
    // }

}
