class Solution {
    public int maxArea(int[] heights) {
         int maxArea = 0;
         int l = 0;
         int r = heights.length -1;

         while(l < r){
            int cWidth = r -l;
            int minHeight = Math.min(heights[l], heights[r]);

            int cArea= cWidth * minHeight;

            maxArea = Math.max(maxArea, cArea);

            if( heights[l] < heights[r]){
              l++;
            }else{
             r--;
            }
         }

        return maxArea;
    }
}
