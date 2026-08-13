// revision 2
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // stores indices of max elements
        Deque<Integer> slidingWindowDeque = new ArrayDeque<>();
        int[] maxes = new int[nums.length - k + 1];
        for(int r=0;r<nums.length;r++) {
            int l = r - k + 1;
            // pop out from front end the indices less that l
            while(!slidingWindowDeque.isEmpty() && slidingWindowDeque.peekFirst() < l) {
                slidingWindowDeque.pollFirst();
            }

            // insert current element into deque back. If other elements are smaller, remove them
            // since curr element will always be bigger in window. Only future elements can be smaller
            // and retained
            while(!slidingWindowDeque.isEmpty() 
                && nums[slidingWindowDeque.peekLast()] <= nums[r]) {
                    slidingWindowDeque.pollLast();
            }

            
            slidingWindowDeque.offerLast(r);
            if(l >= 0 ) {
                maxes[l] = nums[slidingWindowDeque.peekFirst()];
            }
        }
        return maxes;
    }
}
