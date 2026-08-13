class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int low = 0, high = matrix.length * matrix[0].length;
        int rc = matrix.length;
        int cc = matrix[0].length;
        // row = index / cc
        // col = index % cc

        while(low < high) {
            int mid = low + (high-low)/2;
            int row = mid/cc;
            int col = mid%cc;
            int value = matrix[row][col];
            if(value == target) return true;
            if(value < target) {
                // go right;
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return false;
    }
}
