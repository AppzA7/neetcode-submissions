class Solution {
    public int trap(int[] height) {
        // water at index i = min(leftMax[i], rightMax[i]) - height[i];
        // trapped water = sum of water at every i
        int n = height.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = height[0];
        suffix[n-1] = height[n-1];

        for(int i=1;i<n; i++) {
            prefix[i] = Math.max(prefix[i-1], height[i]);
            int j = n - 1 - i;
            suffix[j] = Math.max(suffix[j+1], height[j]);
        }

        int trappedWater = 0;
        for(int i=0;i<n;i++) {
            trappedWater += Math.min(prefix[i], suffix[i]) - height[i];
        }
        return trappedWater;
    }
}
