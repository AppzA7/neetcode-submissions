class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> lastPosition = new HashMap<>();

        int right = 0, left = 0;
        int max = 0;

        while(right < n) {
            int lastPositionOfRightPointer = lastPosition.getOrDefault(s.charAt(right), -1);
            if( lastPositionOfRightPointer != -1 && lastPositionOfRightPointer >= left) {
                left = lastPositionOfRightPointer + 1;
            }
            lastPosition.put(s.charAt(right), right);
            right++;
            max = Math.max(max, right - left);
        }
        return max;
    }
}
