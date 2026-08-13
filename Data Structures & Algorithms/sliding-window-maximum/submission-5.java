// revision 1
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deq = new ArrayDeque<>();

        // deque stores indices of the max element that are in the window. smaller elements in the window
        // can be pushed out since they will not be maximum in the window while the larger element
        // exists in the window.
        int[] result = new int[nums.length - k + 1];
        int left = 0, right = 0;

        while(right < nums.length) {
            while(!deq.isEmpty() && deq.peekFirst() < left) deq.pollFirst();
            while(!deq.isEmpty() && nums[deq.peekLast()] < nums[right]) deq.pollLast();
            deq.offerLast(right);
            if(right >= k-1) {
                result[left++] = nums[deq.peekFirst()];
            }
            right++;
        }

        return result;
    }
}
