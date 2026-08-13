class Solution {
    record Point(int x, int y) {};
    record Edge(Point a, Point b) implements Comparable<Edge> {
        int distance() {
            return Math.abs(b.y - a.y) + Math.abs(b.x - a.x);
        }

        @Override
        public int compareTo(Edge other) {
            return distance() - other.distance();
        }
    }
    public int minCostConnectPoints(int[][] points) {
        Queue<Edge> edgeQ = new PriorityQueue<>();

        for(int i=0;i<points.length-1;i++) {
            Point a = new Point(points[i][0], points[i][1]);
            for(int j=i+1;j<points.length;j++) {
                Point b = new Point(points[j][0], points[j][1]);
                Edge e = new Edge(a, b);
                edgeQ.offer(e);
            }
        }

        int selectedEdges = 0;
        int cost = 0;
        while(!edgeQ.isEmpty() && selectedEdges < points.length - 1) {
            Edge e = edgeQ.poll();
            if(union(e.a, e.b)) {
                selectedEdges++;
                cost += e.distance();
            }
        }
        return cost;
    }

    Map<Point, Point> parent = new HashMap<>();
    Map<Point, Integer> rank = new HashMap<>();

    Point find(Point a) {
        if(!parent.containsKey(a)) {
            return a;
        }

        Point rootA = find(parent.get(a)); 
        parent.put(a, rootA);
        return rootA;
    }

    boolean union(Point a, Point b) {
        Point rootA = find(a);
        Point rootB = find(b);

        if(rootA.equals(rootB)) {
            return false;
        }

        int rankA = rank.getOrDefault(rootA, 0);
        int rankB = rank.getOrDefault(rootB, 0);

        if(rankA < rankB) {
            parent.put(rootA, rootB);
        } else if(rankA > rankB) {
            parent.put(rootB, rootA);
        } else {
            parent.put(rootA, rootB);
            rank.put(rootB, rankB + 1);
        }
        return true;
    }
}
