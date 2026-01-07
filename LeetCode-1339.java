/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    long totalSum=0;
    long maxProduct=0;
    final int mod=1_000_000_007;

    public int maxProduct(TreeNode root) {
        totalSum=treesum(root);
        computesubtree(root);
        return (int)(maxProduct%mod);
    }

    private long treesum(TreeNode node){
        if(node==null) return 0;
        return treesum(node.left)+treesum(node.right)+node.val;

    }

    private long computesubtree(TreeNode node){
        if(node==null)return 0;
        long left=computesubtree(node.left);
        long right=computesubtree(node.right);

        long subSum=right+left+node.val;
        long product=(totalSum-subSum)*subSum;
        maxProduct=Math.max(product,maxProduct);
        
        return subSum;
    }
}

