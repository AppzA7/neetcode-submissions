class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if(m > n) return false;

        int left = 0, right = m-1;

        int[] expectedCounts = new int[26];
        int[] currentCounts = new int[26];

        for(int i = 0; i < m; i++) {
            expectedCounts[s1.charAt(i)-'a']++;
            currentCounts[s2.charAt(i)-'a']++;
        }
        
        int matches = 0;
        for(int i=0;i<26;i++) {
            if(expectedCounts[i] == currentCounts[i])
            matches++;
        }

        if(matches == 26) return true;
                
        for(right = m; right < n; right++) {
            left = right - m;

            int rightCharIntValue = s2.charAt(right) - 'a';
            
            if(expectedCounts[rightCharIntValue] == currentCounts[rightCharIntValue])
                matches--;
            currentCounts[rightCharIntValue]++;
            if(expectedCounts[rightCharIntValue] == currentCounts[rightCharIntValue])
                matches++;

            int leftCharIntValue = s2.charAt(left) - 'a';
            if(expectedCounts[leftCharIntValue] == currentCounts[leftCharIntValue])
                matches--;
            currentCounts[leftCharIntValue]--;
            if(expectedCounts[leftCharIntValue] == currentCounts[leftCharIntValue])
                matches++;

            if(matches == 26) return true;
        }

        return false;
    }
}
