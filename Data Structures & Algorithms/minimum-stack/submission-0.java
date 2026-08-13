class MinStack {
    Deque<Integer> list;
    Deque<Integer> prefixMinimum;
    
    public MinStack() {
        list = new ArrayDeque<>();
        prefixMinimum = new ArrayDeque();
    }
    
    public void push(int val) {
        if(list.isEmpty()) {
            prefixMinimum.add(val);
        } else {
            prefixMinimum.add(Math.min(val, prefixMinimum.peekLast()));
        }
        list.add(val);
    }
    
    public void pop() {
        list.pollLast();
        prefixMinimum.pollLast();
    }
    
    public int top() {
        return list.peekLast();
    }
    
    public int getMin() {
        return prefixMinimum.peekLast();
    }
}
