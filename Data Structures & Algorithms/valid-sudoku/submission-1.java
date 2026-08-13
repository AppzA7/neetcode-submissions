class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set[] rows = new Set[9];
        Set[] cols = new Set[9];
        Set[][] grid = new Set[3][3];

        for(int i=0;i<3; i++) {
            for(int j=0; j<3; j++) {
                grid[i][j] = new HashSet<>();
                rows[i*3 + j] = new HashSet<>();
                cols[i*3 + j] = new HashSet<>();
            }
        }
        // col or row = col(or)row_i / 3

        for(int row_i=0;row_i<9; row_i++) {
            for( int col_i=0; col_i < 9; col_i++) {
                if (board[row_i][col_i] == '.') continue;
                int value = board[row_i][col_i] - '0';
                if(rows[row_i].contains(value) 
                || cols[col_i].contains(value) 
                || grid[row_i/3][col_i/3].contains(value)) {
                    return false;
                }
                rows[row_i].add(value);
                cols[col_i].add(value);
                grid[row_i/3][col_i/3].add(value);
            }
        }
        return true;
    }
}
