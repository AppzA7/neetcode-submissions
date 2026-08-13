// REVISION - 1 better space complexity and time complexity
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Integer[] indices = new Integer[n];

        for(int i=0;i<n;i++) {
            indices[i] = i;
        }

        // sort indices from closes to target, to farthest to target
        Arrays.sort(
            indices,
            (a,b) -> position[b] - position[a]
        );

        int fleets = 0;
        double time = 0;

        for(int i : indices) {
            double arrivalTime = (target - position[i]) /  (double) speed[i];
            if(arrivalTime > time) {
                fleets++;
                time = arrivalTime;
            }
        }

        return fleets;
    }
}
