import java.util.HashMap;
public class Leet2461 {
    public static long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        long win = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++) {
            //1 windoow sum
            win+=nums[i];
            
            //2 insert in map
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            // if (map.containsKey(nums[i]))
            //     map.put(nums[i], map.get(nums[i]) + 1);
            // else
            //     map.put(nums[i], 1);

            //3 window valid 
            if(i>=k-1){
                
                //4 update winsum, map(remove or update)
                if(i>=k){
                    // dec/remove out of win
                    int freq = map.get(nums[i-k]);
                    freq--;
                    if(freq<=0) map.remove(nums[i-k]); //remove if 0 freq
                    else map.put(nums[i-k], freq); //else update freq
                    // System.out.println(map.get(nums[i-k]));

                    //update window sum
                    win-=nums[i-k];
                }

                //5 check if window is valid or not
                if(map.size()==k) ans = Math.max(ans, win);
            }
            
            // System.out.println(i + " " + ans + " " + win + " " + map.get(nums[i]));
        }
        return ans;
    }

    public static void main(String[] args){
        System.out.println(maximumSubarraySum(new int[]{1,5,4,9,9,9,9}, 3));

        // System.out.println(new Leet2461().maximumSubarraySum(new int[]{1,5,4,2,9,9,9}, 3));
    }
}