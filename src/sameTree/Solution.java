package sameTree;

class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		val = x;
	}
}

public class Solution {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
	
	public static void main(String[] args){
		Solution f = new Solution();
		TreeNode n1 = new TreeNode(0);
		TreeNode n2 = new TreeNode(1);
		System.out.println(f.isSameTree(n1, n2));
	}
}
