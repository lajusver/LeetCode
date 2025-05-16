class Solution {
    public int sumNumbers(TreeNode root) {
        Stack<TreeNode> stack1 =new Stack<>();
        Stack<Integer> stack2=new Stack<>();

        stack1.push(root);        
        stack2.push(root.val);
        int sum=0;
        while(!stack1.isEmpty()){
            TreeNode curr=stack1.pop();
            int num=stack2.pop();
            if(curr.right==null && curr.left==null){
                sum+=num;
            }

            if(curr.right!=null){
                stack1.push(curr.right);
                stack2.push(num*10+curr.right.val);
            }

            if(curr.left!=null){
                stack1.push(curr.left);
                stack2.push(num*10+curr.left.val);
            }
        }
        return sum;
    }
}
