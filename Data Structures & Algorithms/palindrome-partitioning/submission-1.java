class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        backtrack(s, 0, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
        String s,
        int start,
        int currentIndex,
        List<String> partition,
        List<List<String>> result
    ) {
        // No more characters available to extend the substring
        if (currentIndex == s.length()) {
            if (start == s.length()) {
                result.add(new ArrayList<>(partition));
            }
            return;
        }

        // Choice 1: cut after currentIndex
        if (isPalindrome(s, start, currentIndex)) {
            partition.add(s.substring(start, currentIndex + 1));

            backtrack(
                s,
                currentIndex + 1,
                currentIndex + 1,
                partition,
                result
            );

            partition.remove(partition.size() - 1);
        }

        // Choice 2: do not cut; extend the current substring
        backtrack(
            s,
            start,
            currentIndex + 1,
            partition,
            result
        );
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }

        return true;
    }
}