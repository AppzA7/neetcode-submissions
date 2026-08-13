class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // A : [..    Aleft|Aright.]
        // B : [...Bleft|Bright   .] 

        // find a partition in the two arrays such that
        // max(Aleft, Bleft) < min(Aright, Bright)
        // this would be the partition when the array is split in half
        // x elements from A and n/2-x elements from B.
        // do search in smaller of A and B so time complexity is O(log(min(a, b)));

        int[] shorter = nums1.length < nums2.length ? nums1 : nums2;
        int[] bigger = nums1.length < nums2.length ? nums2 : nums1;

        int l = nums1.length + nums2.length;

        int left = -1, right = shorter.length - 1;
        while(left <= right) {
            // -1 => left is empty
            // 0 => left is 0th element
            // n-1 => right is empty
            int aPartition = left + (right - left) / 2;
            int bPartition = l/2 - aPartition - 2;

            // 10 elements total => 5
            //  aPartition = -1, 2
            // bPartition = 0-4 => 4, 0,1
            int Aleft = aPartition == -1 ? Integer.MIN_VALUE : shorter[aPartition];
            int Aright = aPartition == shorter.length-1 ? Integer.MAX_VALUE : shorter[aPartition+1];

            int Bleft = bPartition == -1 ? Integer.MIN_VALUE : bigger[bPartition];
            int Bright = bPartition == bigger.length-1 ? Integer.MAX_VALUE : bigger[bPartition+1];

            // Aleft <= Bright and Bleft <= Aright :=> valid
            // Aleft > Bright => 
            if(Aleft > Bright) {
                //move left in A
                right = aPartition-1;
            } else if( Bleft > Aright) {
                // move right in A
                left = aPartition+1;
            } else {
                // correct partition
                if(l%2 == 1) {
                    // odd, first element on right side
                    return Math.min(Bright, Aright);
                } else {
                    return (Math.max(Aleft, Bleft) + Math.min(Bright, Aright))/ (double) 2;
                }
            }
        }
        return -1;
    }
}
