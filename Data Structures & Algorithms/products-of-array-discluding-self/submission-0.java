class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = 1;
        for(int i=1;i<nums.length; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];            
        }

        int suffix = 1;
        for(int i=nums.length-1;i>=0; i--) {
            prefix[i] *= suffix;
            suffix *= nums[i];            
        }

        // int[] result = new int[nums.length];
        // for(int i=0;i<nums.length; i++) {
        //     result[i] = prefix[i] * suffix[i];
        // }

        return prefix;
    }
}  
