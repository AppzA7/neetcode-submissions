class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> retList = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, target, new ArrayList<>(), retList);
        return retList;
    }

    public void helper(int nums[], int i, int target, List<Integer> subList, List<List<Integer>> retList) {
        if(target == 0) {
            retList.add(new ArrayList<>(subList));
            return;
        }

        for(;i<nums.length;i++) {
            if(target - nums[i] < 0) break;
            subList.add(nums[i]);
            helper(nums, i, target - nums[i], subList, retList);
            subList.removeLast();
        }
    }
}
