class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    void backtrack(int[] nums, int start, List<Integer> subList, List<List<Integer>> result) {
        result.add(new ArrayList<>(subList));

        for(int i=start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) continue;
            subList.add(nums[i]);
            backtrack(nums, i+1, subList, result);
            subList.remove(subList.size() - 1);
        }
    }
}
