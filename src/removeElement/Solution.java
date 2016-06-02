package removeElement;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int u = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val) nums[u++] = nums[i];
        }
        return u;
    }
}