class Solution {
    public boolean hasDuplicate(int[] nums) {
        Hashtable<Integer, Boolean> seen = new Hashtable<>();
        for(int i=0; i < nums.length; i++) {
            if(seen.containsKey(nums[i])) return true;
            seen.put(nums[i], true);
        }
        return false;
    }
}