class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while(l <= r) {
            int m = l + (r-l)/2;
            
            if(target == nums[m]) return m;
            if(nums[l] <= nums[m]) {
                //left half is sorted
                if(nums[l] <= target && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                // right half is sorted
                if(nums[m] < target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }

        }
        return -1;
    }
}
