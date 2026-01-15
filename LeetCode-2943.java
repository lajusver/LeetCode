class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxHGap=calculateMaxGap(hBars,n);
        int maxVGap=calculateMaxGap(vBars,m);

        int side=Math.min(maxVGap,maxHGap);
        return side*side;
    }

    private int calculateMaxGap(int []bars,int limit){
        Arrays.sort(bars);
        int curr=1;
        int maxGap=1;

        for(int i=1;i<bars.length;i++){
            if(bars[i]==bars[i-1]+1){
                curr++;
            }
            else{
                maxGap=Math.max(maxGap,curr+1);
                curr=1;
            }
        }
        maxGap=Math.max(maxGap,curr+1);
        return maxGap;
    }
}   