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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<>();
        que.offer(root);
        int max_sum=Integer.MIN_VALUE;
        int level=1;
        int ans_level=1;

        while(!que.isEmpty()){
            int size=que.size();
            int level_sum=0;

            for(int i=0;i<size;i++){
                TreeNode node=que.remove();
                level_sum+=node.val;
                if(node.left!=null)que.offer(node.left);
                if(node.right!=null)que.offer(node.right);
            }
            if(level_sum>max_sum){
                max_sum=level_sum;
                ans_level=level;
            }
            level++;
        }
        return ans_level;

    }
}