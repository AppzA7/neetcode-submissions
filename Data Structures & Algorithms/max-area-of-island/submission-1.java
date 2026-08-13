class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int maxRows = grid.length;
        int maxCols = grid[0].length;
        boolean[][] visited = new boolean[maxRows][maxCols];

        int maxArea = 0;

        for(int row = 0; row < maxRows; row++) {
            for(int col = 0; col < maxCols; col++) {
                if(!visited[row][col] && grid[row][col] == 1) {
                    int area = getArea(visited, grid, row, col);
                    maxArea = area > maxArea ? area : maxArea;
                }
            }
        }

        return maxArea;
    }

    private static final int[][] DIRECTIONS = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    protected int getArea(boolean[][] visited, int[][] grid, int row, int col) {
        if(
            row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length || 
            visited[row][col] || 
            grid[row][col] == 0
        ) {
            return 0;
        }

        visited[row][col] = true;
        int area = 1;
        for(int[] direction : DIRECTIONS) {
            area += getArea(visited, grid, row + direction[0], col + direction[1]);
        }
        return area;
    }
}
