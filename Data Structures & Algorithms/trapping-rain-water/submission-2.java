class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = height[0];
        int rightMax = height[n-1];
        int trappedWater = 0;

        int l = 0, r = n-1;
        while(l < r) {
            if(leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                // water will be bound by this value since this is the smallest
                // between current two maxes.
                trappedWater += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                trappedWater += rightMax - height[r];
            }
        }
        return trappedWater;
    }
}
