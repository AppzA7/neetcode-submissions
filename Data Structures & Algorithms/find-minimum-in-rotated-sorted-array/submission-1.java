class Solution {
    public int findMin(int[] nums) {
        // nums[right] > nums[left], return nums[left] because correct order
        // find mid such that nums[mid - 1] > nums[mid] < nums[mid+1]
        int left = 0, right = nums.length-1;
        int n = nums.length;
        if(nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }

        while(left < right) {
            int mid = left + (right - left) / 2;
            
            // n[l] > n[m] <= n[r] => check left segment
            // n[l] > n[m] >= n[r] => check right segment will not happen in asc sorted case
            // n[l] < n[m] <= n[r] => check left segment
            // n[l] < n[m] >= n[r] => check right segment
            
            // if(nums[left] >= nums[mid]) {
                if(nums[mid] <= nums[right]) {
                    right = mid;
                } else {
                    left = mid+1;
                }
            // } else {
            //     if(nums[mid <= nums[right]]) {
            //         right = mid;
            //     } else {
            //         left = mid + 1;
            //     }
            // }
        }
        return nums[right];
    }
}
