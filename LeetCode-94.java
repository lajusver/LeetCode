class Solution {
    List<Integer> a=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root==null) return new ArrayList<>();
        inorderTraversal(root.left);
        a.add(root.val);
        inorderTraversal(root.right);
        return a;
    }
}