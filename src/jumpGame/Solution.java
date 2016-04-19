package jumpGame;

public class Solution {
    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        int index = 0;
        while(index < nums.length && index <= maxIndex){
            maxIndex = Math.max(maxIndex, nums[index] + index);
            index++;
            if(maxIndex >= nums.length-1) return true;
        }
        return false;
    }
}