class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum=0;
        int min_count=0;
        int minabsvalue=Integer.MAX_VALUE;

        for(int[] row: matrix){
            for(int num:row){
                int mnum=Math.abs(num);
                sum+=mnum; 
                if(num<0)min_count++;
                if(mnum<minabsvalue)minabsvalue=mnum;
            }
        }
        if(min_count%2==0) return sum;
        else sum-=2L*minabsvalue;
        return sum;
    }
}