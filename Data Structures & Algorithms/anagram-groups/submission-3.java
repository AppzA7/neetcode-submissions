class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> returnList = new HashMap<>();
        for( var s : strs ) {
            String key = s.chars()
                            .sorted()
                            .mapToObj(c -> String.valueOf(c))
                            .collect(Collectors.joining());
            List<String> tempList = returnList.getOrDefault(key, new ArrayList<>());
            tempList.add(s);
            returnList.put(key, tempList);
        }

        return new ArrayList<>(returnList.values());
    }
}
