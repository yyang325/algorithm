package searchForARange;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;res[1] = -1;
        help(res, nums, 0, nums.length-1, target);
        return res;
    }
    
    public void help(int[] res, int[] nums, int s, int e, int target){
        if(s < 0 || e >= nums.length || s > e) return;
        int mid = s + (e-s)/2;
        if(nums[mid] > target){
            help(res, nums, s, mid-1, target);
        }else if(nums[mid] < target){
            help(res, nums, mid+1, e, target);
        }else{
            res[0] = (res[0] == -1 || res[0] > mid) ? mid : res[0];
            res[1] = (res[1] == -1 || res[1] < mid) ? mid : res[1];
            help(res, nums, s, mid-1, target);
            help(res, nums, mid+1, e, target);
        }
    }
    
    public static void main(String[] a){
    	Solution f = new Solution();
    	int[] nums = {1,4};
    	for(int i: f.searchRange(nums, 4)){
    		System.out.println(i);
    	}
    }
}