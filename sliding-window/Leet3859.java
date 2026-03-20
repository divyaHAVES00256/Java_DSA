import java.util.HashMap;

public class Leet3859{
    public long countSubarrays(int[] nums, int k, int m) {
        int l = 0; int r = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        long count = 0; //it count subarrays when we incounter freq>m
        long ans = 0;
        int valid = 0;//count how many elemnt have freq m, when invalid window we reset it and start again
        while(r<nums.length){
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);
            if(map.get(nums[r]) == m) valid++; //TRICK
            //invalid window-shrink
            while(map.size()>k && map.get(nums[l])!=null && l<nums.length){
                if(map.get(nums[l])==m) valid--; //TRICK
                //we check ==m beacuse if>=m done becoz imagine while incoundiring invalid window
                // 333 111 22 1 44(k = 2, m =2);
                // here at index 5 window become invlid
                // then you reduce l, 3 is has freq>m reduce it, at next 3 it is freq=m, reduce invalid
                // now doing the same when we reach the element 1 the window is 1112 which will be valid but if we take>=m and reduce valid, the valid will be reduced too and hence whil ecalculating ans, it will give wrong output
                map.put(nums[l], map.get(nums[l])-1);
                if(map.get(nums[l])==0)map.remove(nums[l]);
                // System.out.println(l + " invalid " + r);
                l++;

               count=0;
            }

            //valid window but extra frequency-shrink
            while(map.size()==k && map.get(nums[l])>m){//TRICK
                count++;
                map.put(nums[l], map.get(nums[l])-1);
                if(map.get(nums[l])==0)map.remove(nums[l]);
                // System.out.println(l + " extra " + r + " " + count);
                l++;
                
            }

            //calculate answer
            if(map.size() == k && valid==k) ans+=(1+count);//TRICK //if the valid conditionn is not taken it will count all the answer with size k - wrong output
             
            //  System.out.println(" map " +map);
            //  System.out.println(l + " ans " + r + " " + count + " " + ans);
            r++;
        }

        return ans;
            
    }
}