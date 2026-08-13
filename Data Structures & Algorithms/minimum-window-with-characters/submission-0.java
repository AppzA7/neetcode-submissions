class Solution {
    public String minWindow(String s, String t) {
        int minLength = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int[] characters = new int[52];

        for(char c : t.toCharArray()) {
            characters[getIndex(c)]++;
        }
    
        String minString = "";
        while(right < s.length()) {
            characters[getIndex(s.charAt(right))]--;
            right++;
            while(satisfied(characters)) {
                int newMinLength = Math.min(minLength, right - left);
                if(newMinLength < minLength) minString = s.substring(left, right);
                minLength = newMinLength;
                characters[getIndex(s.charAt(left))]++;
                left++;
            }
        }

        return minString;
    }

    private Integer getIndex(char c) {
        if(c <= 'z' && c >= 'a') return c - 'a';
        else return 26 + c - 'A';
    }

    private Boolean satisfied(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i] > 0) return false;
        }
        return true;
    }
}
