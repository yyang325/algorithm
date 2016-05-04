package combination3;

import java.util.*;

public class Solution {
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        help(res, new ArrayList<Integer>(), k, n, 1);
        return res;
    }
    
    public void help(List<List<Integer>> res, List<Integer> list, int k, int n, int start){
        if(k > 9 || k < 1 || n < 2*k || n > 9*k || start > 9) return ;
        if(k == 1 && n >= start){
            list.add(n);
            res.add(list);
            return;
        }
        for(int i = start; i <= 9; i++){
            
            List<Integer> newlist = new ArrayList<Integer>(list);
            newlist.add(i);
            help(res, newlist, k-1, n-i, i+1);
        }
    }
    
    
    public static void main(String[] a){
    	Solution f = new Solution();
    	List<List<Integer>> res = f.combinationSum3(2, 6);
    	for(List<Integer> list: res){
    		for(int i: list){
    			System.out.print(i + "\t");
    		}
    		System.out.println();
    	}
    }
}