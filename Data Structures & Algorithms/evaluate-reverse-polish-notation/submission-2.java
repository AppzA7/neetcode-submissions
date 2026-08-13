class Solution {
    public int evalRPN(String[] tokens) {
        int[] stk = new int[tokens.length];
        int top = 0;

        for(String s : tokens) {
            switch(s) {
                case "+", "-", "*", "/" -> {
                    int left = stk[top-2];
                    int right = stk[--top];
                    switch(s) {
                        case "+" -> stk[top-1] = left + right;
                        case "-" -> stk[top-1] = left - right;
                        case "*" -> stk[top-1] = left * right;
                        case "/" -> stk[top-1] = left / right;
                    }
                }
                default -> stk[top++] = Integer.parseInt(s);
            }
        }
        return stk[0];
    }
}
