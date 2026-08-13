class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Boolean> entries = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(entries.containsKey(nums[i])) {
                return true;
            } else {
                entries.put(nums[i], true);
            }
        }
        return false;
    }
}
