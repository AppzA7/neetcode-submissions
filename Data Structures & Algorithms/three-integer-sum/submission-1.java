class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ll = new ArrayList<>();
        for(int i=0;i<nums.length - 2; i++) {
            if(nums[i] > 0) break;
            int left = i + 1;
            int right = nums.length - 1;
            //skip the same lists
            if(i > 0 && nums[i] == nums[i-1]) continue;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    ll.add(List.of(nums[i], nums[left], nums[right]));
                    left++;right--;
                    while(left < right && nums[left] == nums[left-1]) left++;
                } else if(sum > 0) right--;
                else left++;
            }
        }
        return ll;
    }
}
