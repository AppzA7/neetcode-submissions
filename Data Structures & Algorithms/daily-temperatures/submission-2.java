class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // for every element, first maximum after it
        //stk to store indices of large temperatures
        Deque<Integer> stk = new ArrayDeque<>();

        int[] results = new int[temperatures.length];
        for(int i=temperatures.length-1 ;i>=0; i--) {
            while(!stk.isEmpty() && temperatures[stk.peek()] <= temperatures[i]) stk.pop();
            if(!stk.isEmpty())
                results[i] = stk.peek() - i;
            stk.push(i);
        }

        return results;
    }
}
