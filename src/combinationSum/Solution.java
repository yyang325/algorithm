package combinationSum;

import java.util.*;

public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length < 1) return res;
        Arrays.sort(candidates);
        for(int i = 0; i < candidates.length; i++){
            if(i > 0 && candidates[i] == candidates[i-1]) continue;
            List<Integer> list = new ArrayList<>();list.add(candidates[i]);
            help(candidates, list, res, i, target-candidates[i]);
        }
        return res;
    }
    
    public void help(int[] candidates, List<Integer> list, List<List<Integer>> res, int index, int target){
        if(index >= candidates.length) return;
        if(target == 0) {
        	res.add(list);
        	return;
        }
        if(target < candidates[index]) return;
        
        
        for(int i = index; i < candidates.length; i++){
            List<Integer> newlist = new ArrayList<>(list);
            newlist.add(candidates[i]);
            help(candidates, newlist, res, i, target-candidates[i]);
        }
    }
    
    
    public static void main(String[] args){
    	Solution f = new Solution();
    	int[] arr  = {2,3,6,7};
    	List<List<Integer>> res = f.combinationSum(arr, 7);
    	for(List<Integer>l : res){
    		for(int i: l){
    			System.out.print(i + " ");
    		}
    		System.out.println();
    	}
    }
}