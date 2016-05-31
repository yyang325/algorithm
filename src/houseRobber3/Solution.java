package houseRobber3;

class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int val){
		this.val = val;
	}
}

public class Solution {
    public int rob(TreeNode root) {
        int[] res = help(root);
        return Math.max(res[0], res[1]);
    }
    
    
    public int[] help(TreeNode root){
        int[] res = new int[2];
        if(root == null) return res;
        if(root.left == null && root.right == null){
            res[0] = 0;
            res[1] = root.val;
            return res;
        }
        int[] left = help(root.left);
        int[] right = help(root.right);
        res[0] = Math.max(left[0],left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}