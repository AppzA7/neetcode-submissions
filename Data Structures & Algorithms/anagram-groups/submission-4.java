class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> returnList = new HashMap<>();
        for( var s : strs ) {
            String key = getKey(s);
            returnList.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(returnList.values());
    }

    protected String getKey(String s) {
        int[] counts = new int[26];

        for( char c : s.toCharArray() ) {
            counts[c - 'a']++;
        }

        StringBuilder key = new StringBuilder();
        for( var i : counts) {
            key.append('#').append(i);
        }

        return key.toString();
    }
}
