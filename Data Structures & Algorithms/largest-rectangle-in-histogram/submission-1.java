class Solution {
    public int largestRectangleArea(int[] heights) {
        // 7, 1, 7, 2, 2, 4
        // 7, 1, 1, 1, 1, 1 left min
        // 1, 1, 2, 2, 2, 4  right min including number


    //     H
    //     HH     HH
    //     HHH H  HH
    //     HHH HHHHH
    //     HHHHHHHHH
    //     012345678
    //     0   1  2  3  4  5  6  7  8
    //     5   4  3  1  3  2  2  4  4
    //   l 0   0  0  0  3  3  3  6  6
    //   r 1   2  3  8  5  9  9  9  9

    //     8, 

    //     if stk empty, push to stack, left boundary = cur
    //     pop on stack till stk empty or h[top] < cur
    //         if stk empty, left boundary = 0
    //         else left boundary = top
    //     push to stack cur

    //     3, 6,
    //     0, 0, 0, 0, 3, 3, 3, 6, 6

    //     3, 2, 1, 0
    //     8, 8 , 8, 8, 5, 8, 3, 2, 1
        //7, 1, 7, 6, 5, 2, 4
        //1, 1, 2, 2, 2, 2, 4
        //1, 1, 2, 2, 2, 2, 4
        int n = heights.length;
        Deque<Integer> stk = new ArrayDeque<>();

        int[] leftMins = new int[n];
        int[] rightMins = new int[n];
        
        for(int i=0;i<n; i++) {
            if(stk.isEmpty()) {
                leftMins[i] = -1;
            } else {
                while(!stk.isEmpty() && heights[stk.peek()] >= heights[i]) stk.pop();
                if(stk.isEmpty()) leftMins[i] = -1;
                else leftMins[i] = stk.peek();
            }
            stk.push(i);
        }
        stk.clear();
        for(int i=n-1;i>=0; i--) {
            if(stk.isEmpty()) {
                rightMins[i] = n;
            } else {
                while(!stk.isEmpty() && heights[stk.peek()] >= heights[i]) stk.pop();
                if(stk.isEmpty()) rightMins[i] = n;
                else rightMins[i] = stk.peek();
            }
            stk.push(i);
        }

        /*
            H
            HH     HH
            HHH H  HH
            HHH HHHHH
            HHHHHHHHH
            012345678
            543132244
               i
            stk : 3(1)
            leftMins: 9, 9, 9, 9, 5, 9, 3

        */  
        int maxArea = 0;
        for(int i=0;i<n;i++) {
            int leftBoundary = leftMins[i];
            int rightBoundary = rightMins[i];
            int areaBetween = (rightBoundary - leftBoundary - 1)*heights[i];
            maxArea = Math.max(areaBetween, maxArea);
        }

        // for(int i=0;i<n;i++) {
        //     System.out.print(leftMins[i] + ",");
        // }
        // System.out.println("");
        // for(int i=0;i<n;i++) {
        //     System.out.print(rightMins[i] + ",");
        // }
        // System.out.println("");
        return maxArea;
    }
}
