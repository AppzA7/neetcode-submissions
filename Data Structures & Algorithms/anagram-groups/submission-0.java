class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<AnagramKey, List<String>> map = new HashMap<>();

        for(String s : strs) {
            AnagramKey k = new AnagramKey(s);
            if(map.containsKey(k)) {
                map.get(k).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(k, list);
            }
        }

        return map.values().stream().collect(Collectors.toList());
        
    }

    
    class AnagramKey {
        final int[] p;

        public AnagramKey() {
            p = new int[26];
        }
        public AnagramKey(String s) {
            p = new int[26];
            initKey(s);
        }

        public void initKey(String s) {
            s.chars().forEach(c -> p[c - 'a']++);
        }

        public final int[] getBaseArray() {
            return p;
        }
        @Override
        public boolean equals(Object obj) {
            if(obj instanceof AnagramKey other) {
                final int[] otherp = other.getBaseArray();
                for(int i=0;i<26;i++) {
                    if(p[i] != otherp[i]) return false;
                }
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(p);
        }
    }
}
