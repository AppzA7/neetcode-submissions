class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[] timeAtPosition = new double[target];

        for(int i=0;i<position.length; i++) {
            timeAtPosition[position[i]] = (target - position[i]) / (double) speed[i];
        }

        double maxTime = 0.0;
        int fleets = 0;

        for(int i=target - 1; i >=0; i--) {
            double curTime = timeAtPosition[i];
            if(curTime > maxTime) {
                maxTime = curTime;
                fleets++;
            }
        }
        return fleets;
    }
}
