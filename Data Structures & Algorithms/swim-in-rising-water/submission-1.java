class Solution {
    public int swimInWater(int[][] grid) {
       return dijkstra(grid, new boolean[grid.length][grid.length]);
    }

    private static final int[][] DIRECTION = { {0,1}, {1,0}, {0,-1}, {-1,0} };

    int dijkstra(int grid[][], boolean visited[][]) {
        
        int n = grid.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->Integer.compare(a[0], b[0]));
        queue.offer(new int[]{grid[0][0], 0, 0});

        int maxSoFar = grid[0][0];

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            visited[cur[1]][cur[2]] = true;

            if(cur[1] == n-1 && cur[2] == n-1) {
                return cur[0];
            }

            for(int[] dir : DIRECTION) {
                int newx = cur[1] + dir[0];
                int newy = cur[2] + dir[1];

                if(
                    newx < 0 ||
                    newy < 0 ||
                    newx >= n ||
                    newy >= n ||
                    visited[newx][newy]
                ) {
                    continue;
                } else {
                    int minCostToReachCell = Math.max(cur[0], grid[newx][newy]);
                    queue.offer(new int[] {minCostToReachCell, newx, newy});
                }
            }
        }
        return maxSoFar;
    }
}
