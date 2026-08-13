class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int n = nums.length;
        int[] maxs = new int[n - k + 1];

        // 0 1 2 3 4
        // L---J
        for(int right = 0; right < n; right++) {
            // remove indices smaller than the window from the front of the queue;
            while(!q.isEmpty() && q.peekFirst() < right - k + 1) {
                q.pollFirst();
            }

            // remove elements smaller than the current element from the back of the queue and insert the current element
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[right]) {
                q.pollLast();
            }
            q.offerLast(right);

            // left of queue has the maximum value since all elements less than max would have been removed by first loop
            if(right >= k-1)
                maxs[right - k + 1] = nums[q.peekFirst()];
        }

        return maxs;
    }
}
