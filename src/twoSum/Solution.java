package twoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2) return null;
		Map<Integer, Integer> map = new HashMap<>();
		int[] res = new int[2];
		
		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(nums[i])){
				res[0] = map.get(nums[i]);
				res[1] = i;
				return res;
			}else{
				map.put(target-nums[i], i);
			}
		}
		return null;
	}
}