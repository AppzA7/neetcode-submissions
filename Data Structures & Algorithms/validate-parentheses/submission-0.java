class Solution {
    public boolean isValid(String s) {
        Deque<Character> stk = new ArrayDeque<>();

        Map<Character, Character> matchingBracket = new HashMap<>();

        matchingBracket.put(']', '[');
        matchingBracket.put('}', '{');
        matchingBracket.put(')', '(');

        for(char c : s.toCharArray()) {
            if(c == '[' || c == '{' || c == '(') {
                stk.push(c);
            } else {
                if(stk.isEmpty() || stk.peek() != matchingBracket.get(c)) return false;
                stk.pop();
            }
        }
        return stk.isEmpty();
    }
}
