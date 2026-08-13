class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rn = matrix.length, cn = matrix[0].length;
        int rlow = 0, clow = 0, rhigh = rn, chigh = cn;

        while(rlow < rhigh && clow < chigh) {
            int cmid = clow + (chigh - clow)/2;
            int rmid = rlow + (rhigh - rlow)/2;
            int value = matrix[rmid][cmid];
            if(value == target) {
                return true;
            }
            if(target < value) { // go left or above
                if(target >= matrix[rmid][0]) {
                    // within same col
                    chigh = cmid;
                } else {
                    // have to go to next lower section of row
                    rhigh = rmid;
                    // reset col trackers
                    clow = 0;
                    chigh = cn;
                }
            } else { // go right or below
                if(target <= matrix[rmid][cn-1]) {
                    // within same col
                    clow = cmid+1;
                } else {
                    rlow = rmid+1;
                    // reset col trackers
                    clow = 0;
                    chigh=cn;
                }
            }
        }
        return false;
    }
}
