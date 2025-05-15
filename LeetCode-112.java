class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;

        if(root.right==null && root.left==null){
            return root.val == targetSum;
        }

        int newTarget=targetSum-root.val;
        return hasPathSum(root.left,newTarget) || hasPathSum(root.right,newTarget);
    }
}
