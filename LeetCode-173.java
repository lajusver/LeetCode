class BSTIterator {
    Stack <TreeNode> st=new Stack<>();

    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }
    
    public int next() {
        TreeNode n=st.pop();
        if(n.right!=null){
        pushLeft(n.right);
        }
        return n.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }

    public void pushLeft(TreeNode node){
        while(node!=null){
            st.push(node);
            node=node.left;
        }
    }
}