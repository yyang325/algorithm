package pathSum2;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        help(res, new ArrayList<Integer>(), root, sum);
        return res;
    }
    
    public void help(List<List<Integer>> res, List<Integer> list, TreeNode root, int num){
        if(root == null) return;
        if(root.left == null && root.right == null){
            if(root.val == num){
            	List<Integer> nl = new ArrayList<>(list);
                nl.add(root.val);
                res.add(nl);
            }
            return;
        }
        
        List<Integer> newList = new ArrayList<>(list);
        newList.add(root.val);
        num -= root.val;
        
        help(res, newList, root.left, num);
        help(res, newList, root.right, num);
    }
    
    public static void main(String[] a){
    	Solution f = new Solution();
    	TreeNode root = new TreeNode(0);
    	root.left = new TreeNode(1);
    	root.right = new TreeNode(1);
    	List<List<Integer>> res = f.pathSum(root, 1);
    	for(List<Integer> l: res){
    		for(int i: l){
    			System.out.print(i);
    		}
    		System.out.println();
    	}
    }
}