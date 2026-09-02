class MinStack {

    long min;
    Deque<Long> stack;

    public MinStack() {
        stack = new ArrayDeque<>();  
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            min = val;
            stack.push(val - min);
        } else {
            long inVal = val - min;
            stack.push(inVal);
            if(inVal < 0) {
                min = val;
            }
        }
    }
    
    public void pop() {
        long top =  stack.pop();
        if(top < 0) {
            min = min - top;
        }
    }
    
    public int top() {
        if(stack.peek() < 0) return (int)min;
        return (int) (stack.peek() + min);
    }
    
    public int getMin() {
        return (int) min;
    }
}
