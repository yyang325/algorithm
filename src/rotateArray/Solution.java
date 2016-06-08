package rotateArray;

public class Solution {
    public void rotate(int[] nums, int k) {
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    
    public void reverse(int[] nums, int s, int e){
    	while(s < e){
    		int temp = nums[s];
    		nums[s] = nums[e];
    		nums[e] = temp;
    		s++;e--;
    	}
    }
    
    public void print(int[] nums){
    	System.out.println("\narray is: ");
    	for(int i : nums){
    		System.out.print(i);
    	}
    }
    
    public static void main(String[] a){
    	Solution f = new Solution();
    	int[] arr = {1,2,3};
    	f.print(arr);
    	f.rotate(arr, 2);
    	f.print(arr);
    }
}