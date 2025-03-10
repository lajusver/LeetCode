class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int l=colors.length;
        int left=0;
        int res=0;
        for(int right=1;right<l+k-1;right++){
            if(colors[right % l]== colors[(right -1)%l]){
                left=right;
            }
            if(right-left+1==k){
                res++;
                left++;
            }
        }
        return res;
    }
}