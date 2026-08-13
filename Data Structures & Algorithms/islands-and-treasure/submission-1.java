class Solution {
    public void islandsAndTreasure(int[][] grid) {
        // find treasure points. iterate out wards from each point.
        // stop an iteration if the distance at that point is less that cur distance
        // update and continue with neighbours 

        Queue<int[]> queue = new ArrayDeque<>();

        for(int i=0;i<grid.length; i++) {
            for(int j=0; j < grid[0].length; j++ ) {
                if(grid[i][j] == 0) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        bfs(grid, queue);
    }

    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    void bfs(int[][] grid, Queue<int[]> queue) {
        int[] nullNode = {-1,-1};
        queue.add(nullNode);
        while(!queue.isEmpty()){
            int[] pos = queue.poll();

            int x = pos[0];
            int y = pos[1];

            // continue if out of bounds or already visited
            

            for(int[] direction : DIRECTIONS) {
                int nextRow = x + direction[0];
                int nextCol = y + direction[1];

                if(nextRow < 0 || nextCol < 0 || nextRow >= grid.length || nextCol >= grid[0].length) continue;
                if(grid[nextRow][nextCol] != Integer.MAX_VALUE) continue; // means the cell was already visited earlier
                grid[nextRow][nextCol] = grid[x][y] + 1;
                queue.add(
                    new int[] {
                        nextRow,
                        nextCol
                    }
                );
            }
        }
    }


}
