class Solution {
   
    public int maxArea(int[] heights) {
        int l = 0, h = heights.length - 1;
        int maxArea = 0;
        while (l < h) {
            int area = (h - l) * Math.min(heights[l], heights[h]);
            if (area > maxArea) {
                maxArea = area;
            }
            if (heights[l] < heights[h]) {
                l++;
            } else {
                h--;
            }
        }
        return maxArea;
    }
}


// 1 7 2 5 4 7 3 6

// 1 - 1  2 3 4 5 6 7 
// 7 - 2 10 12 28 15 36 
// 2 - 2 4 6 8 10



