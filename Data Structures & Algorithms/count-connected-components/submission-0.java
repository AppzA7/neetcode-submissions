class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int connectedComponents = 0;
        boolean[] visited = new boolean[n];

        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                dfs(graph, visited, i);
                connectedComponents++;
            }
        }
        return connectedComponents;
    }

    void dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        if(!visited[node]) {
            visited[node] = true;
            for(int neighbor : graph.get(node)) {
                dfs(graph, visited, neighbor);
            }
        }
    }
}
