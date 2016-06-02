package removeDuplicatesFromSortedArray;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int fast = 1, slow = 1;
        while(fast < nums.length){
            if(nums[fast] != nums[fast-1]){
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}