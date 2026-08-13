class Solution {
    public String minWindow(String s, String t) {
        int left = 0, right = 0, minStart = 0, minLength = Integer.MAX_VALUE;
        int missing = t.length();

        if(s.length() < t.length()) return "";
        int[] characters = new int[128];

        for(char c : t.toCharArray()) {
            characters[c]++;
        }

        while(right < s.length()) {
            char c = s.charAt(right);
            if(characters[c] > 0) {
                missing--;
            }
            characters[c]--;

            while(missing == 0) {
                int length = right - left + 1;
                if(length < minLength) {
                    minStart = left;
                    minLength = length;
                }
                char leftChar = s.charAt(left);
                characters[leftChar]++;
                if(characters[leftChar] > 0) {
                    missing++;
                }
                left++;
            }
            right++;
        }
        if(minLength != Integer.MAX_VALUE)
        return s.substring(minStart, minStart + minLength);
        else return "";
    }
}
