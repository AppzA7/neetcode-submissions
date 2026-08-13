class Solution {
    private static final int[][] DIRECTIONS = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    private static final int ATLANTIC = 1;
    private static final int PACIFIC = 0;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int maxRows = heights.length;
        int maxCols = heights[0].length;
        
        boolean[][][] flowState = new boolean[maxRows][maxCols][2];

        // set initial flowStates for adjacent to ocean cells
        for(int col = 0; col < maxCols; col++) {
            flowState[0][col][PACIFIC] = true;
            flowState[maxRows-1][col][ATLANTIC] = true;
        }

        for(int row = 0; row < maxRows; row++) {
            flowState[row][0][PACIFIC] = true;
            flowState[row][maxCols-1][ATLANTIC] = true;
        }

        Queue<int[]> q = new ArrayDeque<>();

        // add the edges excluding rows and cols
        for(int col=0; col < maxCols; col++) {
            q.add(new int[]{0, col});
            q.add(new int[]{maxRows-1, col});
        }

        for(int row=0; row < maxRows; row++) {
            q.add(new int[]{row, 0});
            q.add(new int[]{row, maxCols-1});
        }

        // multi bfs through the grid

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            for(int[] direction : DIRECTIONS) {
                int nextRow = curRow + direction[0];
                int nextCol = curCol + direction[1];

                if(
                    nextRow < 0 || 
                    nextCol < 0 || 
                    nextRow >= maxRows ||
                    nextCol >= maxCols ||
                    heights[nextRow][nextCol] < heights[curRow][curCol]
                ) {
                    continue;
                }

                boolean flowChanged = false;
                for(int ocean = 0; ocean < 2; ocean++) {
                    if(
                        flowState[curRow][curCol][ocean] == true && 
                        flowState[nextRow][nextCol][ocean] != flowState[curRow][curCol][ocean]
                    ) {
                        flowState[nextRow][nextCol][ocean] = true;
                        flowChanged = true;
                    }
                }

                if(flowChanged) {
                    q.add(new int[]{nextRow, nextCol});
                }
            }
        }

        List<List<Integer>> output = new ArrayList<>();
        for(int i=0;i<maxRows; i++) {
            for(int j=0;j < maxCols; j++) {
                if(flowState[i][j][0] == true && flowState[i][j][1] == true) {
                    output.add(List.of(i,j));
                }
            }
        }

        return output;
    }
}
