package binaryTreePath;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
	int val;
	TreeNode left, right;
	public TreeNode(int x){
		val = x;
	}
}
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        help(res, new StringBuilder(), root);
        return res;
    }
    
    public void help(List<String> res, StringBuilder sb, TreeNode root){
        if(root == null) return;
        if(root.left == null &&  root.right == null){
            sb.append(root.val);
            res.add(sb.toString());
            return ;
        }
        sb.append(root.val).append("->");
        if(root.left != null){
            StringBuilder newSb = new StringBuilder(sb);
            help(res, newSb, root.left);
        }
        if(root.right != null){
            StringBuilder newSb = new StringBuilder(sb);
            help(res, newSb, root.right);
        }
    }
}