class Solution {
    public void solve(char[][] board) {
        boolean[][] hasEdgeAccess = new boolean[board.length][board[0].length];
        Queue<int[]> bfsQ = new ArrayDeque<>();

        for(int i=0;i<board.length;i++) {
            addIfOpen(board, hasEdgeAccess, bfsQ, i, 0);
            addIfOpen(board, hasEdgeAccess, bfsQ, i, board[0].length-1);
            
        }

        for(int i=0;i<board[0].length;i++) {
            addIfOpen(board, hasEdgeAccess, bfsQ, 0, i);
            addIfOpen(board, hasEdgeAccess, bfsQ, board.length-1, i);
        }

        bfs(board, hasEdgeAccess, bfsQ);
    }

    void addIfOpen(char[][] board, boolean[][] hasEdgeAccess, Queue<int[]> bfsQ, int i, int j) {
        if(
            board[i][j] == 'O' && 
            !hasEdgeAccess[i][j]
        ) {
            hasEdgeAccess[i][j] = true;
            bfsQ.add(new int[]{i, j});
        }
    }

    private static int[][] DIRECTIONS = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    void bfs(char[][] board, boolean[][] hasEdgeAccess, Queue<int[]> bfsQ) {
        while(!bfsQ.isEmpty()) {
            int[] cur = bfsQ.poll();
            int curx = cur[0];
            int cury = cur[1];

            for(int[] direction : DIRECTIONS) {
                int nextx = curx + direction[0];
                int nexty = cury + direction[1];

                if(
                    nextx < 0 ||
                    nexty < 0 ||
                    nextx >= board.length ||
                    nexty >= board[0].length ||
                    board[nextx][nexty] == 'X' ||
                    hasEdgeAccess[nextx][nexty]
                ) {
                    continue;
                }

                hasEdgeAccess[nextx][nexty] = true;
                bfsQ.add(new int[]{nextx, nexty});
            }
        }

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] == 'O' && !hasEdgeAccess[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
