class MinStack {

    Deque<Long> stack;
    long min;
    //
    // nums : 4, 3, 5, 6, 2, 4, 1
    // stk  : 0, -1, 2, 3, -1, 2, -1
    // min  : 4, 3, 2, 1
    // top - min

    // reconstruct
    // st = stk.top()
    // st < 0 ? 
    // current element = min
    // min = min - st
    // else curr element = min + st
    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            min = val;
            stack.push(0l);
        } else {
            stack.push(val - min);
            min = Math.min(min, val);
        }
    }
    
    public void pop() {
        long difference = stack.poll();
        if(difference < 0) {
            min = min - difference;
        }
    }
    
    public int top() {
        long difference = stack.peek();
        if(difference < 0) {
            return (int) min;
        }
        return (int) (min + difference);
    }
    
    public int getMin() {
        return (int) min;
    }
}
