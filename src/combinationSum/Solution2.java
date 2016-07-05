package combinationSum;

import java.util.*;

public class Solution2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length < 1) return res;
        Arrays.sort(candidates);
        for(int i = 0; i < candidates.length; i++){
            if(i > 0 && candidates[i] == candidates[i-1]) continue;
            List<Integer> list = new ArrayList<>();
            list.add(candidates[i]);
            help(res, list, candidates, i+1, target-candidates[i]);
        }
        return res;
    }
    
    
    public void help(List<List<Integer>> res, List<Integer> list, int[] candidates, int index, int target){
        if(target == 0) {
            res.add(list);
            return;
        }
        if(index >= candidates.length) return;
        if(target < candidates[index]) return;
        
        for(int i = index; i < candidates.length; i++){
            if(i > index && candidates[i] == candidates[i-1]) continue;
            List<Integer> nlist = new ArrayList<>(list);
            nlist.add(candidates[i]);
            help(res, nlist, candidates, i+1, target-candidates[i]);
        }
    }
}