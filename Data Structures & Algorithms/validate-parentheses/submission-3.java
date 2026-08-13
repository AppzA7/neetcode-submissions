class Solution {
    public boolean isValid(String s) {
        Deque<Character> stk = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            switch(c) {
                case '[' -> stk.push(']');
                case '{' -> stk.push('}');
                case '(' -> stk.push(')');

                case '}', ']', ')' -> {
                    if(stk.isEmpty() || stk.pop() != c) return false;
                }
            }
        }

        return stk.isEmpty();
    }
}
