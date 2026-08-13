class Solution {

    private static final int[][] DIRECTIONS = {
        {-1, 0},
        {0, 1},
        {1, 0},
        {0, -1}
    };

    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;

        if(word.length() > r * c ) return false;

        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if(word.charAt(0) == board[i][j]) {
                    boolean result = search(board, word, 0, i, j);
                    if(result) return true;
                }
            }
        }
        return false;
    }

    boolean search(char[][] board, String word, int index, int row, int col) {
        if(index == word.length()) return true;

        if(row < 0 || col < 0 
        || row >= board.length || col >= board[0].length) return false;

        if(board[row][col] != word.charAt(index)) return false;
        board[row][col] = '#';
        for(int[] direction : DIRECTIONS) {
            boolean result = 
            search(board, word, index + 1, row + direction[0], col  +direction[1]);
            if(result) return true;
        }
        board[row][col] = word.charAt(index);
        return false;
    }
}
