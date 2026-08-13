class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    void backtrack(String s, int startOfCurrentSubstring,
     List<String> substrings, List<List<String>> result) {
        if(startOfCurrentSubstring == s.length()) {
            result.add(new ArrayList<>(substrings));
            return;
        }

        for(int i=startOfCurrentSubstring; i < s.length(); i++) {
            if(!isPalindrome(s, startOfCurrentSubstring, i)) continue;

            substrings.add(s.substring(startOfCurrentSubstring, i+1));
            backtrack(s, i+1, substrings, result);
            substrings.remove(substrings.size() - 1);
        }
    }

    Boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }   
        return true;
    }
}
