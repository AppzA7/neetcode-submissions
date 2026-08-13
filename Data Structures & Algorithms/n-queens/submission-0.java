class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        dfs(n, 0, new ArrayList<>(), result, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return result;
    }

    void dfs(
        Integer n,
        Integer rowIndex,
        List<String> choices, 
        List<List<String>> results,
        Set<Integer> colSet,
        Set<Integer> tlbrd,
        Set<Integer> bltrd) {
            if(rowIndex == n) {
                results.add(new ArrayList<>(choices));
                return;
            }

            for(int colIndex=0;colIndex<n;colIndex++) {
                if(isValidSquare(rowIndex, colIndex, colSet, tlbrd, bltrd)) {
                    colSet.add(colIndex);
                    tlbrd.add(colIndex - rowIndex);
                    bltrd.add(colIndex + rowIndex);
                    char[] tempC = new char[n];
                    Arrays.fill(tempC, '.');
                    tempC[colIndex] = 'Q';
                    choices.add(new String(tempC));
                    dfs(n, rowIndex+1, choices, results, colSet, tlbrd, bltrd);
                    choices.remove(choices.size()-1);
                    colSet.remove(colIndex);
                    tlbrd.remove(colIndex - rowIndex);
                    bltrd.remove(colIndex + rowIndex);
                }
            }
    }

    boolean isValidSquare(
        int r,
        int c, 
        Set<Integer> colSet, 
        Set<Integer> tlbrd,
        Set<Integer> bltrd) {
        /*
            0,0  0,1  0,2  0,3
            1,0  1,1  1,2  1,3
            2,0  2,1  2,2  2,3
            3,0  3,1  3,2  3,3
        */

        // diagonals 
        // 1. y-x is the same
        // 2. y+x is the same

        // cols set
        // rows set

        //iterating through rows, so ignore rows.
        //  have set for column, 
        // have set for top left to bottom right diagonal
        // have set for bottom left to top right diagonal
        if(colSet.contains(c)) return false;
        if(tlbrd.contains(c-r)) return false;
        if(bltrd.contains(c+r)) return false;
        return true;
    }
}
