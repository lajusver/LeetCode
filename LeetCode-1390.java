class Solution {
    public int sumFourDivisors(int[] nums) {
        int total=0;
        for(int i=0;i<nums.length;i++){
        total+=checkDivisor(nums[i]);
        }
        return total;
    }

    public int checkDivisor(int num){
        int count=0;
        int sum=0; 
        for(int i=1;i*i<=num;i++){
            if(count>4)break;
            if(num%i==0){
            sum+=i;
            int temp=num/i;
            sum+=temp;
            count+=2;
            if(i*i==num){
            count--;
            sum-=i;
            }
            }
        }
        if(count==4)return sum;
        return 0;
    }
}