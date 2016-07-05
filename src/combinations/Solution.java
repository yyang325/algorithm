package combinations;

import java.util.*;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        help(res, new ArrayList<Integer>(), n, k, 1);
        return res;
    }
    
    public void help(List<List<Integer>> res, List<Integer> list, int n, int k, int start){
        
        if(k == 0){
            res.add(list);
            return;
        }
        if(start > n-k+1) return;
        
        for(int i = start; i <= n; i++){
            List<Integer> nlist = new ArrayList<>(list);
            nlist.add(i);
            help(res, nlist, n, k-1, i+1);
        }
        
    }
    
    public static void main(String[] args){
    	Solution f = new Solution();
    	List<List<Integer>> res = f.combine(4, 2);
    	for(List<Integer> l: res){
    		for(int i : l){
    			System.out.print(i + " ");
    		}
    		System.out.println();
    	}
    }
}