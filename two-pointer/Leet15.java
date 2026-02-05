import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leet15 {
    //tc: n^2(fully two pointer)
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i<nums.length-2; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;//1* very important: here skipping same elemnts reduces tc also lookups for already analyzed element ALSO REMOVES DUPLICATES

            
            //2: fixing i and run two pointer for tar
            //why start from j=i+1 and not 0?
            //bc before elements have already been analyzed also if for i prevous elment can be triplets then vice a versa is also true ie for prevous element i is also a triplet
            //so if have analyzed prevous again analyzing them will create duplicates
            int j = i+1, k=nums.length-1;
            int tar = -nums[i];

            while(j<k){
                int sum = nums[j]+nums[k];
                if(sum==tar){ 
                    //if atrget is found add in the result and keep running pointers for other possiblities
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++; 
                    // k--;
                    
                    //* very important this will help in handling duplicates: how?
                    //let say we fount j which is already analyzed that means it will have same k but we do not want duplicates hence skip same j
                    //same logic for k(we can skip k while loop too because outer loop will handle this but using for k will reduce more lookups)
                    while(j<k && nums[j]==nums[j-1])j++; 
                    // while(j<k && nums[j]==nums[j-1]) k--;
                } 
                else if(sum<tar) j++;
                else k--; 

            }
        }
        return res;
    }
    // static void generate(int[] arr, int index, int r, java.util.List<Integer> current) {

    //     // BASE CASE: all elements have been decided
    //     if (index == arr.length) {
    //         if (current.size() == r) {
    //             System.out.println(current);
    //         }
    //         return;
    //     }

    //     // INCLUDE current element
    //     current.add(arr[index]);
    //     generate(arr, index + 1, r, current);

    //     // EXCLUDE current element (backtrack)
    //     current.remove(current.size() - 1);
    //     generate(arr, index + 1, r, current);
    // }

    static void generate(int[] arr, int start, int r, java.util.List<Integer> current) {

        // BASE CASE: required size reached
        if (current.size() == r) {
            System.out.println(current);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            current.add(arr[i]);
            generate(arr, i + 1, r, current);
            current.remove(current.size() - 1);
        }
    }


    static void generate(int[] arr, int start, int r, java.util.List<Integer> current, Set<List<Integer>> set) {

        // BASE CASE: required size reached
        if (current.size() == r) {
            System.out.println(current);
            int sum = current.get(0)+current.get(1)+current.get(2);
            if(sum==0)  set.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            current.add(arr[i]);
            generate(arr, i + 1, r, current, set);
            current.remove(current.size() - 1);
        }

        // Set<List<Integer>> set = new HashSet<>();
        // generate(nums, 0, 3, new ArrayList<>(), set);
        // return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int r = 3;

        generate(arr, 0, r, new java.util.ArrayList<>());
        int tar = 9;
        // System.out.println();
        int[] ans = new int[2];
         System.out.println(ans.length + " jgjhb " + ans[0] + ans[1]);

    }


}
