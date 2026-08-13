class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> edges = new ArrayList<>();
        for(int i=0;i<numCourses;i++) {
            edges.add(new ArrayList<>());
        }
        for(int[] dependency : prerequisites) {
            indegree[dependency[0]]++;
            edges.get(dependency[1]).add(dependency[0]);
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        int processed = 0;
        while(!q.isEmpty()) {
            int course = q.poll();
            processed++;

            for(int neighbor : edges.get(course)) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        return processed == numCourses;

    }
}
