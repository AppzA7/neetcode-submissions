class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> posMap = new HashMap<>();

        for(int i=0;i<nums.length; i++) {
            int newtarget = target - nums[i];
            if(posMap.containsKey(newtarget)) {
                if(newtarget == nums[i]) {
                    List<Integer> list = posMap.get(newtarget);
                    return new int[]{list.get(0), i};
                }
                return new int[]{posMap.get(newtarget).get(0), i};
            }
            if(posMap.containsKey(nums[i])) {
                posMap.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                posMap.put(nums[i], list);
            }
            
        }
        return null;
    }
}
