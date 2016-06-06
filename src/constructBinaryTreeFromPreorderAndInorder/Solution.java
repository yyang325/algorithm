package constructBinaryTreeFromPreorderAndInorder;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    public TreeNode buildTree(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2){
        if(s1 > e1 || s2 > e2 || s1 < 0 || s2 < 0 || e1 >= preorder.length || e2 >= inorder.length) return null;
        if(s1 == e1 || s2 == e2) return new TreeNode(preorder[s1]);
        
        int rootVal = preorder[s1];
        TreeNode root = new TreeNode(rootVal);
        int mid = 0;
        for(int i = s2; i <= e2; i++){
            if(inorder[i] == rootVal){
                mid = i;
                break;
            }
        }
        root.left = buildTree(preorder, s1+1, mid-s2+s1, inorder, s2, mid-1);//num = mid-s2+1       s1+1 + mid-s2
        root.right = buildTree(preorder, mid-s2+s1+1, e1, inorder, mid+1, e2);
        return root;
    }
    
    public static void main(String[] a){
    	Solution f = new Solution();
    	int[] preorder = {1,2};
    	int[] inorder = {2,1};
    	@SuppressWarnings("unused")
		TreeNode root = f.buildTree(preorder, inorder);
    }
}