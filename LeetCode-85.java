class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        if(matrix==null||matrix.length==0)return 0;

        int rows=matrix.length;
        int columns=matrix[0].length;

        int[] heights=new int[columns];
        int maxArea=0;

        for(int r=0;r<rows;r++){
            
            for(int c=0;c<columns;c++){
                if(matrix[r][c]=='1'){
                    heights[c]+=1;
                }
                else {
                    heights[c]=0;
                }
            }
            maxArea=Math.max(maxArea,largestRectangle(heights));
        }
    return maxArea;   
    }

    private int largestRectangle(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {

            int currHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {

                int h = heights[stack.pop()];
                int right = i;
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = right - left - 1;

                maxArea = Math.max(maxArea, h * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
    
}