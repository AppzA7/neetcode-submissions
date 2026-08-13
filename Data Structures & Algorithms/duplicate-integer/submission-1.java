class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Boolean> seen = new HashMap<>();
        for(int i=0; i < nums.length; i++) {
            if(seen.containsKey(nums[i])) return true;
            seen.put(nums[i], true);
        }
        return false;
    }
}