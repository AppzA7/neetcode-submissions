class Solution {
    public int evalRPN(String[] tokens) {
        int[] stk = new int[tokens.length];
        int top = 0;

        for(String s : tokens) {
            switch(s) {
                case "+" -> stk[top-2] = stk[top-2] + stk[--top];
                case "-" -> stk[top-2] = stk[top-2] - stk[--top];
                case "*" -> stk[top-2] = stk[top-2] * stk[--top];
                case "/" -> stk[top-2] = stk[top-2] / stk[--top];
                default -> stk[top++] = Integer.parseInt(s);
            }
        }
        return stk[0];
    }
}
