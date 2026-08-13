// instead of finding left boundary and right boundary in 2 passes, 
// when we are popping something off the stack when we find new element at i, 
// it means that for the popped element, the element at i is right boundary
// means we can check what is there on the stack before it or else -1 as the left boundary
// and calculate area.
// this implies we have to go through the entire stack + one more to check for the full stack
// since otherwise we might not pop till we reach the end of the stack
// ex for arr 3,2,1, we will not consider the 1, 1, 1 area 
class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = heights.length;

        int maxArea = 0;
        for(int i=0;i<=n;i++) {
            int currentHeight = (i == n) ? 0 : heights[i];
            while(!stack.isEmpty() && heights[stack.peek()] > currentHeight) {
                int height = heights[stack.pop()];
                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
                int width = i - leftBoundary - 1;
                maxArea = Math.max(maxArea, width * height);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
