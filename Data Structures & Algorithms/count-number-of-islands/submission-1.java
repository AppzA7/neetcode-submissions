class Solution {
    private static final int [][] DIRECTIONS = {
        {-1, 0}, {1, 0}, {0, 1}, {0, -1}
    };

    public int numIslands(char[][] grid) {
        int maxRows = grid.length;
        int maxCols = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();

        int islands = 0;
        for(int i=0;i<maxRows;i++) {
            for(int j=0;j<maxCols;j++) {
                if(grid[i][j] == '1') {
                    q.add(new int[] {i, j});
                    grid[i][j] = '0';

                    while(!q.isEmpty()) {
                        int[] curr = q.poll();

                        for(int[] direction: DIRECTIONS) {
                            int newx = curr[0] + direction[0];
                            int newy = curr[1] + direction[1];
                            if(newx < 0 || newx >= maxRows || newy < 0 || newy >= maxCols) continue;
                            if(grid[newx][newy] == '1') {
                                grid[newx][newy] = '0';
                                q.add(new int[]{newx, newy});
                            }
                        }
                    }
                    islands++;
                }
            }
        }
        return islands;
    }
}
