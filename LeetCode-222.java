class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int left=getlh(root);
        int right=getrh(root);

        if(left==right){
            return (1 << left) -1;
        }
        else{
            return 1+countNodes(root.left)+countNodes(root.right);
        }
    }

    public int getlh(TreeNode a){
        int lh=0;
        while(a!=null){
            a=a.left;
            lh++;
        }
        return lh;
    }

    public int getrh(TreeNode a){
        int rh=0;
        while(a!=null){
            a=a.right;
            rh++;
        }
        return rh;
    }
}