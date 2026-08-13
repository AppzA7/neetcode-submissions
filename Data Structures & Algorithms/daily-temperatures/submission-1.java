class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // for every element, first maximum after it
        //stk to store indices of large temperatures
        Deque<Integer> stk = new ArrayDeque();

        int[] results = new int[temperatures.length];
        int it = temperatures.length -1;
        for(int i=temperatures.length-1 ;i>=0; i--) {
            while(!stk.isEmpty() && temperatures[stk.peek()] <= temperatures[i]) stk.pop();
            if(stk.isEmpty() || temperatures[stk.peek()] == temperatures[i]) results[it--] = 0;
            else
                results[it--] = stk.peek() - i;
            stk.push(i);
        }

        return results;
    }
}
