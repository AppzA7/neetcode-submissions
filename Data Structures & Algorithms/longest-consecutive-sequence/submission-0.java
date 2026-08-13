class Solution {
    public int longestConsecutive(int[] nums) {

        int largest_chain = 0;
        Set<Integer> seen = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for(int i=0;i<nums.length;i++) {
            if(seen.contains(nums[i]+1)) continue;
            int num = nums[i];
            int chain_length = 0;
            while(seen.contains(num)) {
                chain_length++;
                num = num-1;
            }
            largest_chain = Math.max(largest_chain, chain_length);
        }
        return largest_chain;
    }
}
