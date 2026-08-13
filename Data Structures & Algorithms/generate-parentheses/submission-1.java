class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    void backtrack(int n, int open, int closed, StringBuilder sb, List<String> result) {
        if(open == n && closed == n) {
            result.add(sb.toString());
            return;
        }

        if(open < n) {
            backtrack(n, open+1, closed, sb.append("("), result);
            sb.deleteCharAt(sb.length()-1);
        }
        
        if(open > closed) {
            backtrack(n, open, closed+1, sb.append(")"), result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
