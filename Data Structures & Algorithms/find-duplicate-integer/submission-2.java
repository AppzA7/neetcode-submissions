class Solution {
    public int findDuplicate(int[] nums) {
        // since the numbers are starting from 1, we can take number from 0 and check for cycles in num -> nums[num]
        int slow = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        // cycle and slow == fast
        // find cycle start. a = k(b+c) - b, k = 1 => a = c; b is meeting point inside cycle, c is remaining distance in cycle, a is lengfth to cycle

        slow = nums[0];

        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        } 

        return slow;
    }
}
