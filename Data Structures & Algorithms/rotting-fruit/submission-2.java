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

        int time = 0;

        while(!q.isEmpty() && freshOrangeCount > 0) {
            int levelSize = q.size();

            for(int i = 0; i < levelSize; i++) {
                int[] cur = q.poll();
                for(int[] direction : DIRECTIONS) {
                    int newRow = cur[0] + direction[0];
                    int newCol = cur[1] + direction[1];

                    if(
                        newRow < 0 ||
                        newCol < 0 ||
                        newRow >= grid.length ||
                        newCol >= grid[0].length ||
                        grid[newRow][newCol] != 1
                    ) {
                        continue;
                    }

                    grid[newRow][newCol] = 2;
                    q.add(new int[] {newRow, newCol});
                    freshOrangeCount--;
                }           
            }
            
            time++;
        }

        if(freshOrangeCount == 0) return time;
        return -1;
    }
}
