class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] chosen = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, chosen, new ArrayList<>(), result);
        return result;
    }

    void backtrack(int[] nums, boolean[] chosen, List<Integer> subList, List<List<Integer>> result) {
        if(subList.size() == nums.length) {
            result.add(new ArrayList<>(subList));
            return;
        }

        for(int i=0;i<nums.length;i++) {
            if(chosen[i]) continue;
            chosen[i] = true;
            subList.add(nums[i]);
            backtrack(nums, chosen, subList, result);
            subList.removeLast();
            chosen[i] = false;
        }
    }
}
