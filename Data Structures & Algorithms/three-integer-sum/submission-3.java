class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        List<List<Integer>> ret = new ArrayList<>();
        while(index < nums.length) {
            int firstNum = nums[index];
            List<List<Integer>> resList = twoSum(index + 1, nums.length - 1, -firstNum, nums);
            for (List<Integer> pair : resList) {
                ret.add(List.of(firstNum, pair.get(0), pair.get(1)));
            }
            while(index < nums.length - 1 && nums[index] == nums[index+1]) index++;
            index++;
        }
        return ret;
    }

    protected List<List<Integer>> twoSum(int startIndex, int endIndex, int target, int[] nums) {
        List<List<Integer>> pairs = new ArrayList<>();
        while(startIndex < endIndex) {
            int sum = nums[startIndex] + nums[endIndex];
            if(sum < target) startIndex++;
            else if (sum > target) endIndex--;
            else {
                pairs.add(List.of(nums[startIndex], nums[endIndex]));
                int leftVal = nums[startIndex];
                int rightVal = nums[endIndex];
                while (startIndex < endIndex && nums[startIndex] == leftVal) startIndex++;
                while (startIndex < endIndex && nums[endIndex] == rightVal) endIndex--;
            }
        }
        return pairs;
    }
}
