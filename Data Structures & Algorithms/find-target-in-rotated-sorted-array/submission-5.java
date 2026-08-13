class Solution {
    public int search(int[] nums, int target) {
        int l = 0, n = nums.length-1, r = n;
        while(l <= r) {
            int m = l + (r-l)/2;
            int value = nums[m];

            System.out.println("Target, value " + target + " " + value );
            if(target == value) return m;

            // find which half target can be in
            // l ... m ... r           t < m                    t > m
            // l < m < r               left                     right
            // l >= m < r               left                     t < l, right, else left
            // l <= m > r               t<r, right, else left    right
            
            if(nums[l] <= value && value <= nums[r]) {
                if(target < value) r = m - 1;
                else l = m + 1;
            } else if(nums[l] >= value && value < nums[r]) { 
                if(target < value) r = m - 1;
                else {
                    if(target < nums[l]) l = m + 1;
                    else r = m - 1;
                }
            } else {
                if(target > value) l = m + 1;
                else {
                    if(target <= nums[r]) l = m + 1;
                    else r = m - 1;
                }
            }
            
        }
        return -1; 
    }
}
