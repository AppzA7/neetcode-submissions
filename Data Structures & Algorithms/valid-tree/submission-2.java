class Solution {
    public boolean validTree(int n, int[][] edges) {
        // valid tree => exactly n-1 edges and fully connected;
        // if above is true, then cycle won't exist. If not fully connected in dfs, then there is cycle or disconnection
        if(edges.length == 0) return true;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) {
            graph.add(new ArrayList<>());
        }

        if(edges.length != n-1) return false;

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
       
        return n == dfs(graph, 0, new boolean[n]);
    }

    int dfs(List<List<Integer>> graph, int i, boolean[] visited) {
        if(
            i < 0 ||
            i >= graph.size() ||
            visited[i] ||
            graph.get(i).size() == 0 
        ) {
            return 0;
        }

        int connectedCount = 1;
        visited[i] = true;
        for(
            int neighborIndex = 0;
            neighborIndex < graph.get(i).size();
            neighborIndex++
        ) {
            connectedCount += dfs(graph, graph.get(i).get(neighborIndex), visited);
        }

        return connectedCount;
    }
}
