class Solution {
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if(board[i][j] == word.charAt(0)) {
                    boolean result = search(board, new boolean[r][c], word, 0, i, j);
                    if(result) return true;
                }
            }
        }
        return false;
    }

    boolean search(char[][] board, boolean[][] visited, String word, int index, int r, int c){
        if(visited[r][c]) return false;
        int maxRows = board.length;
        int maxCols = board[0].length;
        
        if(board[r][c] == word.charAt(index)) {
            visited[r][c] = true;
            //check sides
            if(index == word.length()-1) return true;
            if(r-1 >= 0) {
                boolean leftResult = search(board, visited, word, index+1, r-1, c);
                if(leftResult) return true;
            }
            if(r+1 < maxRows) {
                boolean rightResult = search(board, visited, word, index+1, r+1, c);
                if(rightResult) return true;
            }
            if(c+1 < maxCols) {
                boolean downResult = search(board, visited, word, index+1, r, c+1);
                if(downResult) return true;
            }
            if(c-1 >= 0) {
                boolean upResult = search(board, visited, word, index+1, r, c-1);
                if(upResult) return true;
            }
            visited[r][c] = false;
        }
        return false;
    }
}
