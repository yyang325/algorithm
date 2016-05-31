package houseRobber2;

public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        if(nums.length == 1) return nums[0];
        int robLast = nums[nums.length-1] + rob(nums, 1, nums.length-3);
        int robLastNot = rob(nums, 0, nums.length-2);
        return Math.max(robLast, robLastNot);
    }
    
    public int rob(int[] nums, int start, int end){
        if(start < 0 || end >= nums.length || start >= nums.length || end < 0 || start > end) return 0;
        int rb = 0, nr = 0;
        for(int i = start; i <= end; i++){
            int newRb = nr + nums[i];
            int newNr = Math.max(rb, nr);
            rb = newRb;
            nr = newNr;
        }
        return Math.max(rb, nr);
    }
}