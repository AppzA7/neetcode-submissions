class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int[] result = new int[numCourses];
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] dependency : prerequisites) {
            int a = dependency[0];
            int b = dependency[1];

            indegree[a]++;
            graph.get(b).add(a);
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        int processed = 0;

        while(!q.isEmpty()) {
            int candidate = q.poll();
            result[processed++] = candidate;
            for(int neighbor : graph.get(candidate)) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        if(processed == numCourses) return result;
        return new int[]{};
    }
}
