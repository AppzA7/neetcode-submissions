class Solution {
    record Edge(int from, int to, int distance) implements Comparable<Edge>{
        @Override
        public int compareTo(Edge other) {
            return Integer.compare(distance, other.distance);
        }
    };

    record State(int to, int totalDistanceFromStart) implements Comparable<State>{
        @Override
        public int compareTo(State other) {
            return Integer.compare(totalDistanceFromStart, other.totalDistanceFromStart);
        }
    };

    public int networkDelayTime(int[][] times, int n, int k) {
        // start node = k;
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for(int[] edge : times) {
            graph.computeIfAbsent(edge[0], key->new ArrayList<>()).add(new Edge(edge[0], edge[1], edge[2]));
        }

        PriorityQueue<State> minEdge = new PriorityQueue<>();
        int time=-1;
        // insert first edges into heap
        for(Edge e : graph.getOrDefault(k, List.of())) {
            minEdge.offer(new State(e.to, e.distance));
        }

        Map<Integer, Integer> distance = new HashMap<>();
        distance.put(k, 0);

        while(!minEdge.isEmpty()) {
            State edge = minEdge.poll();
            System.out.format("At edge %s%n", edge);
            int newDistance = edge.totalDistanceFromStart;
            // ignore edge if it is already in the distance map with lower distance
            if(distance.getOrDefault(edge.to, Integer.MAX_VALUE) < newDistance) continue;

            if(!distance.containsKey(edge.to) || newDistance < distance.get(edge.to)) {
                System.out.format("New distance : %s%n", newDistance);
                distance.put(edge.to, newDistance);
                time = newDistance;
                // add it's edges to queue.
                for(Edge e : graph.getOrDefault(edge.to, List.of())) {
                    minEdge.offer(new State(e.to, newDistance + e.distance));
                }
            }
        }

        System.out.format("Distance size : %s, Graph size : %s%n", distance.size(), graph.size());
        if(distance.size() != n) return -1;
        return time;
    }
}
