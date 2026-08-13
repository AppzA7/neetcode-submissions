class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> retList = new ArrayList<>();

        for(int i=0;i<nums.length; i++) {
            List<Integer> subList = new ArrayList<>();
            subList.add(nums[i]);
            helper(nums, i, target - nums[i], subList, retList);
            subList.removeLast();
        }

        return retList;
    }

    public void helper(int nums[], int i, int target, List<Integer> subList, List<List<Integer>> retList) {
        if(target <= 0) {
            if(target == 0)
                retList.add(new ArrayList<>(subList));
            return;
        }

        for(;i<nums.length;i++) {
            subList.add(nums[i]);
            helper(nums, i, target - nums[i], subList, retList);
            subList.removeLast();
        }
    }
}
