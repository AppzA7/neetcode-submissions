class Solution {
    public boolean isPalindrome(String s) {
        int i=0, j=s.length()-1;

        while(i < j) {
            while(i < j && !isAlNum(s.charAt(i))) i++;
            while(j > i && !isAlNum(s.charAt(j))) j--;
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            j--;i++;
        }
        return true;
    }

    protected boolean isAlNum(char c) {
        return (c >= 'a' && c<='z') || (c >= 'A' && c<='Z') || (c >= '0' && c<='9');
    }
}
