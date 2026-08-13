class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i=0;i<numbers.length;i++) {
            int res = binarySearch(numbers, i+1, numbers.length-1, target - numbers[i]);
            
            if(res != -1) return new int[] {i+1, res+1};
        }
        return new int[] {};
    }

    public int binarySearch(int[] arr, int start, int end, int target) {
        while(start <= end) {
            int m = start + (end - start) / 2;
            // System.out.println("M : " + m);
            if(arr[m] == target) {
                return m;
            } else if(arr[m] < target) {
                start = m + 1;
            } else end = m - 1;
        }
        return -1;
    }
}
