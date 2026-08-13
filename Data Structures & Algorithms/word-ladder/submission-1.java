class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();
        
        for(String word : wordList) {
            List<String> neighbors = getNeighbors(word);
            // add connection between neighbors and node
            graph.put(word, neighbors);
            for(String neighbor : neighbors) {
                graph.computeIfAbsent(neighbor, k -> new ArrayList<>()).add(word);
            }
        }

        if(!graph.containsKey(endWord)) return 0;
        List<String> possibleStartNodes = getNeighbors(beginWord);
        
        Queue<String> bfsQ = new ArrayDeque<>(possibleStartNodes);
        // System.out.format("Contents of q : %s%n", bfsQ);
        // System.out.format("keys of graph : %s%n", graph.keySet());
        int distance = 1;
        Set<String> visited = new HashSet<>();

        while(!bfsQ.isEmpty()) {
            int layerSize = bfsQ.size();
            for(int i=0;i<layerSize;i++) {
                String node = bfsQ.poll();
                if(!graph.containsKey(node)) continue;
                //System.out.format("checking word %s%n", node);
                visited.add(node);
                if(node.equals(endWord)) return distance/2 + 1;
                for(String neighbor : graph.get(node)) {
                    if(!visited.contains(neighbor)) {
                        bfsQ.add(neighbor);
                    }
                }
            }
            distance++;
            //System.out.format("Updated distance to %s%n", distance);
        }

        return 0;
    }

    private List<String> getNeighbors(String word) {
        StringBuilder sb = new StringBuilder();
        List<String> neighbors = new ArrayList<>();
        sb.append(word);
        for(int i=0;i<word.length();i++) {
            char oldChar = word.charAt(i);
            sb.setCharAt(i, '*');
            neighbors.add(sb.toString());
            sb.setCharAt(i, oldChar);
        }

        return neighbors;
    }
}
