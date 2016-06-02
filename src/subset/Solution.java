package subset;

import java.util.*;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 1) return res;
        Arrays.sort(nums);
        help(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
    
    public void help(List<List<Integer>> res, List<Integer> list, int[] nums, int index){
        res.add(list);
        if(index == nums.length){
            return ;
        }
        
        for(int i = index; i < nums.length; i++){
            if(i != index && nums[i] == nums[i-1]) continue;
            List<Integer> newList = new ArrayList<>(list);
            newList.add(nums[i]);
            help(res, newList, nums, i+1);
        }
    }
}