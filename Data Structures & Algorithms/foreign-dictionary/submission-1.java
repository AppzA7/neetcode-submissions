class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, Set<Character>> graph = new HashMap<>();
      Map<Character, Integer> indegree = new HashMap<>();

      for(String word : words) {
        for(char c : word.toCharArray()) {
            graph.putIfAbsent(c, new HashSet<>());
            indegree.putIfAbsent(c, 0);
        }
      }

      for(int i=0;i<words.length - 1; i++) {
        String a = words[i];
        String b = words[i + 1];

        if(a.length() > b.length() && a.startsWith(b)) return "";

        int minLen = Math.min(a.length(), b.length());

        for(int j=0;j<minLen;j++) {
            char c1 = a.charAt(j);
            char c2 = b.charAt(j);
            if( c1 == c2) continue;
            if(graph.get(c1).add(c2)) {
                indegree.put(c2, indegree.get(c2) + 1);
            }
            break;
        }
      }

      Queue<Character> q = new ArrayDeque<>();

      for(char c : indegree.keySet()) {
        if(indegree.get(c) == 0) {
            q.offer(c);
        }
      }

      StringBuilder sb = new StringBuilder();
      while(!q.isEmpty()) {
        char c = q.poll();
        sb.append(c);

        for(char next : graph.get(c)) {
            int degree = indegree.get(next) - 1;
            indegree.put(next, degree);
            if(degree == 0) {
                q.offer(next);
            }
        }
      }

      // check for cycles
      if(sb.length() != indegree.size()) return "";

      return sb.toString();
    }
}
