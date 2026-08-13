class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high = 0;
        int n = piles.length;
        for(int i=0;i<n; i++) {
            high = Math.max(high, piles[i]);
        }

        // with k = high, we need n hours
        // with k = 1, we need E(piles[i]) hours
        // with k >=1 and <=high, we need hours = E( upper bound [piles[i] / k ]) hours
        // we need to find lowest k such that sum < h

        int low = 1;
        while(low < high) {
            int mid = low + (high - low)/2;
            int hours = 0;
            for(int i=0;i<n;i++) {
                hours += piles[i]/mid + (piles[i] % mid == 0 ? 0 : 1);
            }

            if(hours > h) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;
    }

    // 3 6 7 11
    // l 4
    // h 5
    // m 4
    // t 8
}
