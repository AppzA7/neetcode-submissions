class Solution {

    private char[] getChars(int digit) {
        if(digit < 2 || digit > 9) return new char[0];
        
        if(digit == 9) return new char[] {'w', 'x', 'y', 'z'};
        if(digit == 7) return new char[] {'p', 'q', 'r', 's'};
        int startIndex = (digit - 2) * 3 + (digit / 7);
        char startChar = (char)((int)'a' + startIndex);
        return new char[] {startChar, (char)(startChar + 1), (char)(startChar + 2)};
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        dfs(digits, 0, result, new StringBuilder());
        return result;
    }

    void dfs(String digits, int index, List<String> result, StringBuilder sb) {
        if(index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        
        int digit = digits.charAt(index) - '0';

        for(char c : getChars(digit)) {
            sb.append(c);
            dfs(digits, index+1, result, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}
