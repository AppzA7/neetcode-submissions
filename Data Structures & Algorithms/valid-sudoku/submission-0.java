class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> squares = new HashMap<>(); // r/3 * 3 + c/3

        for(int r=0;r<9;r++) {
            for(int c=0;c<9;c++) {
                char cell = board[r][c];
                if(cell == '.') continue;

                if( rows.getOrDefault(r, new HashSet<>()).contains(cell) ||
                    cols.getOrDefault(c, new HashSet<>()).contains(cell) ||
                    squares.getOrDefault(r/3 * 3 + c/3, new HashSet<>()).contains(cell)) {
                        return false;
                } else {
                    rows.computeIfAbsent(r, k-> new HashSet<>()).add(cell);
                    cols.computeIfAbsent(c, k-> new HashSet<>()).add(cell);
                    squares.computeIfAbsent(r / 3 * 3 + c/3, k-> new HashSet<>()).add(cell);
                }
            }
        }
        return true;
    }
}
