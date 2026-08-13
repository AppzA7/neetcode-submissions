class Solution {
    public int orangesRotting(int[][] grid) {
        // multi bfs from rotting fruits. add to queue only if there is a fresh fruit around

        Queue<int[]> q = new ArrayDeque<>();

        int freshOrangeCount = 0;
        for(int i=0;i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if(grid[i][j] == 1) {
                    freshOrangeCount++;
                }
            }
        }

        int[][] DIRECTIONS = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        int[] nullNode = new int[]{-1,-1};
        q.add(nullNode);

        int time = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur == nullNode) {
                if(q.isEmpty()) break;
                time++;
                q.add(nullNode);
                continue;
            }

            for(int[] direction : DIRECTIONS) {
                int newRow = cur[0] + direction[0];
                int newCol = cur[1] + direction[1];

                if(
                    newRow < 0 ||
                    newCol < 0 ||
                    newRow >= grid.length ||
                    newCol >= grid[0].length
                ) {
                    continue;
                }

                if(grid[newRow][newCol] == 1) {
                    grid[newRow][newCol] = 2;
                    q.add(new int[] {newRow, newCol});
                    freshOrangeCount--;
                }
            }
        }

        if(freshOrangeCount == 0) return time;
        return -1;
    }
}
