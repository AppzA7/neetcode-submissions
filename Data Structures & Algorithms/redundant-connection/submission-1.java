class Solution {
    private final record Pair(int a, int b) {};
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1];

        for(int i=1;i<edges.length+1;i++) {
            parent[i] = i;
        }

        for(int[] edge : edges) {
            if(!union(parent, rank, edge)) {
                return edge;
            }
        }

        return new int[0];
    }

    int find(int[] parent, int node) {
        if(parent[node] != node) {
            parent[node] = find(parent, parent[node]);
        }
        return parent[node];
    }

    // union find complexity is O(E * α(n)). α(n) is inverse ackerman function
    boolean union(int[] parent, int[] rank, int[] edge) {
        int a = edge[0];
        int b = edge[1];
        int rootA = find(parent, a);
        int rootB = find(parent, b);

        if(rootA == rootB) return false;

        if(rank[rootA] < rank[rootB]) {
            // A under B
            parent[rootA] = rootB;
        } else if(rank[rootB] > rank[rootA]) {
            parent[rootB] = rootA;
        } else {
            parent[rootB] = rootA;
            rank[rootA]++; 
        }
        return true;
    }

}
