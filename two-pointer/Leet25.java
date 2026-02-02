class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        
        for(int i = 1; i<nums.length; i++){//i: fast pointer
            if(nums[i-1]!=nums[i]) {
                nums[k]=nums[i];
                k++; //k: slow pointer
            }
        }
        return k;
    }
}