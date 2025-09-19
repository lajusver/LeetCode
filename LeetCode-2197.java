class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<nums.length;i++){
            st.push(nums[i]);
            while(st.size()>1){
                int top=st.pop();
                int prev=st.pop();
                int gcd=findGCD(top,prev);
                if(gcd>1){st.push(findLCM(top,prev));}
                else{
                    st.push(prev);
                    st.push(top);
                    break;
                }
            }
        }
        return new ArrayList<>(st);
    }

    public int findGCD(int a,int b){
        if(a==0)return b;
        if(b==0)return a;
        return findGCD(b,a%b);
    }

    public int findLCM(int a,int b){
        int lcm=(a/findGCD(a,b))*b;
        return lcm;
    }
}