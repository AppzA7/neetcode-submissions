class Solution {
    private record Coord(int x, int y) {}

    public int numIslands(char[][] grid) {
        Set<Coord> ones = new HashSet<>();

        int rows = grid.length;
        int cols = grid[0].length;

        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols; j++) {
                if(grid[i][j] == '1') {
                    ones.add(new Coord(i, j));
                }
            }
        }

        int islandsCount = 0;

        while(!ones.isEmpty()) {
            Coord islandEdge = ones.iterator().next();
            removeNeighboursFromSet(ones, islandEdge, rows, cols);
            islandsCount++;
        }

        return islandsCount;
    }

    private static final int[][] DIRECTIONS = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public void removeNeighboursFromSet(Set<Coord> set, Coord coord, int maxRows, int maxCols) {
        if(coord.x() < 0 || coord.y() < 0 || coord.x() >=  maxRows || coord.y() >= maxCols) return;
        if(!set.contains(coord)) return;
        set.remove(coord);

        for(int i=0;i<DIRECTIONS.length; i++) {
            removeNeighboursFromSet(
                set, 
                new Coord(
                    coord.x() + DIRECTIONS[i][0],
                    coord.y() + DIRECTIONS[i][1]
                ),
                maxRows,
                maxCols
            );
        }
    }


}
