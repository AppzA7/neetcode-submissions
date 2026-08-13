class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> retList = new ArrayList<>();

        int totalSubsets = 1 << n;

        for(int mask = 0; mask < totalSubsets; mask++) {
            List<Integer> subList = new ArrayList<>();

            for(int i=0;i<n;i++) {
                if(((mask >> i) & 1) == 1) {
                    subList.add(nums[i]);
                }
            }
            retList.add(subList);
        }
        return retList;
    }
}
