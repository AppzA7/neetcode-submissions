class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];

        for(int i=0; i < 26; i++) freq[i] = 0;

        int left = 0, right = 0;

        int n = s.length();
        int highestFrequency = 0;
        int charactersToReplace = 0;
        int max = 0;
        while(right < n) {
            int rc = s.charAt(right) - 'A';
            freq[rc]++;
            highestFrequency = Math.max(highestFrequency, freq[rc]);
            charactersToReplace = (right - left) - highestFrequency;

            if(charactersToReplace >= k) { //slide window
                freq[s.charAt(left) - 'A']--;
                left++;
                // highestFreqency is not valid anymore unless in increases, but since max size window won't be smaller
                // unless we find a higher frequency, it doesn't matter even if the maxFrequency is lower since we might not 
                // be able to replace in such a window
            }
            right++;
            max = Math.max(max, right - left);
        } 
        return max;
    }
}
