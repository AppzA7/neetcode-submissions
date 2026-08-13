class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // distance : 10
        // 4, 1, 0, 7
        // 2, 2, 1, 1
        //time to reach
        // 3, 4.5, 10, 3
        // car at position i will become part of a fleet of cars ahead of it if they take longer than it
        // 7, 4,  1,  0 positions ordered
        // 3, 3,  4.5, 10
        // if there are any times greater on the left, then ith car in this order will become part of that fleet since it cannot reach faster 
        // f1, f1, f2, f3 

        List<Map.Entry<Integer, Double>> cars = new ArrayList<>();
        for(int i=0;i<position.length; i++) {
            cars.add(new AbstractMap.SimpleEntry<Integer, Double>(
                position[i], (target - position[i])/ (double) speed[i])
            );
        }

        cars.sort(Map.Entry.<Integer, Double>comparingByKey().reversed());
        // cars.sort(Comparator.comparing(Map.Entry<Integer, Double>::getKey).reversed());
        int fleets = 1;
        double currentFleetValue = cars.get(0).getValue();

        for(int i=1;i<position.length; i++) {
            Map.Entry<Integer, Double> car = cars.get(i);
            if(currentFleetValue < car.getValue()) {
                fleets++;
                currentFleetValue = car.getValue();
            }
        }
        return fleets;
    }
}
