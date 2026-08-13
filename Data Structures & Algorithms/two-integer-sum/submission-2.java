class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexOf = new HashMap<>();

        for( int i=0; i<nums.length; i++ ) {
            int toFind = target - nums[i];
            if(indexOf.containsKey(toFind)) return new int[] {indexOf.get(toFind), i};
            indexOf.put(nums[i], i);
        }
        return new int[]{0,0};
    }
}
