class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stk = new ArrayDeque<>();

        for(String s : tokens) {
            switch(s) {
                case "+" -> {
                    Integer second = stk.pop();
                    Integer first = stk.pop();
                    stk.push(first + second);
                }
                case "-" -> {
                    Integer second = stk.pop();
                    Integer first = stk.pop();
                    stk.push(first - second);
                }
                case "*" -> {
                    Integer second = stk.pop();
                    Integer first = stk.pop();
                    stk.push(first * second);
                }
                case "/" -> {
                    Integer second = stk.pop();
                    Integer first = stk.pop();
                    stk.push(first / second);
                }
                default -> {
                    stk.push(Integer.parseInt(s));
                }
            }
        }

        return stk.pop();
    }
}
