package firstMissingPositive;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length < 1) return 1;
        int i = 0;
        while(i < nums.length){
            if(nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i]-1]){
                //swap nums[i]   nums[nums[i]-1]   num[i] = 5   swap with nums[4]
                int temp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[temp-1] = temp;
            }else{
                i++;
            }
        }
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != j+1) return j+1;
        }
        return nums.length+1;
    }
}