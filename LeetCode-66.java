class Solution {
    public int[] plusOne(int[] digits) {
        int last=digits.length-1;
        int temp=0;
        while(temp==0){
        if(digits[last]==9 && last==0)
        {
            int []res=new int[digits.length+1];
            res[0]=1;
            return res;
        }
        if(digits[last]==9){
            digits[last]=0;

        }
        else{
            temp=1;
            digits[last]++;
        }
        if(last>0){
        last--;
        }
        }
        return digits;
    }
}