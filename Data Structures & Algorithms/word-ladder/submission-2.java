/* 
    store the graph as pattern -> word and then iterate through pattern of each word in bfs. this way graph can be 
    shorter 
*/


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();

        for(String word : wordList) {
            graph.computeIfAbsent(word, k-> new ArrayList<>());
            for(String pattern : patterns(word)) {
                graph.computeIfAbsent(pattern,
                    k-> new ArrayList<>()
                ).add(word);
            }
        }

        if(!wordList.contains(endWord)) {
            return 0;
        }

        Queue<String> bfsQ = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        bfsQ.add(beginWord);
        int distance = 1;

        while(!bfsQ.isEmpty()) {
            int levelSize = bfsQ.size();
            for(int i=0;i<levelSize;i++) {
                String node = bfsQ.poll();
                if(node.equals(endWord)) return distance;
                visited.add(node);
                for(String pattern : patterns(node)) {
                    for(String word : graph.getOrDefault(pattern, new ArrayList<>())) {
                        if(visited.contains(word)) continue;
                        bfsQ.add(word);
                    }
                    graph.remove(pattern);  // we don't need to check this pattern again
                }
            }
            distance++;
        }
        return 0;
    }

    private List<String> patterns(String word) {
        StringBuilder sb = new StringBuilder(word);
        List<String> result = new ArrayList<>();
        for(int i=0;i<word.length();i++) {
            char oldChar = word.charAt(i);
            sb.setCharAt(i, '*');
            result.add(sb.toString());
            sb.setCharAt(i, oldChar);
        }   
        return result;
    }
}
