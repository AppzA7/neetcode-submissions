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
        int distance = 0;
        int[] nullNode = {-1,-1};
        queue.add(nullNode);
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            
            if( pos == nullNode) {
                distance++;
                if(queue.isEmpty()) break;
                queue.add(nullNode);
                continue;
            }

            int x = pos[0];
            int y = pos[1];
            // break if current distance is greater than pre existing
            if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) continue;
            if(distance > grid[x][y]) continue;
            grid[x][y] = distance;

            for(int[] direction : DIRECTIONS) {
                queue.add(
                    new int[] {
                        x + direction[0],
                        y + direction[1]
                    }
                );
            }
        }
    }


}
