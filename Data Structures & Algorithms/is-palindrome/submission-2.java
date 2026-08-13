class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 1) return true;
        int i = 0, j = s.length() - 1;
        while(i < j) {
            char lc = s.charAt(i);
            char rc = s.charAt(j);
            while(!Character.isLetterOrDigit(lc) && i < s.length()-1) {
                i++;
                lc = s.charAt(i);
            }
            while(!Character.isLetterOrDigit(rc) && j > 0) {
                j--;
                rc = s.charAt(j);
            }
            if(i > j) return true;
            if(Character.toLowerCase(lc) != Character.toLowerCase(rc)) return false;
            i++;
            j--;
        }
        return true;
    }
}
