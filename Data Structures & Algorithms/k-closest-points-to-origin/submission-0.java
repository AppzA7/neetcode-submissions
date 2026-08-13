class Solution {
    record Point(int x, int y) implements Comparable<Point>{

        @Override
        public int compareTo(Point other) {
            return (other.x() * other.x() + other.y() * other.y()) -
            (x * x + y * y);
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i=0;i<points.length;i++) {
            pq.offer(new Point(points[i][0], points[i][1]));
            if(pq.size() > k) pq.poll();
        }

        int[][] ret = new int[k][2];
        for(int i=0;i<k;i++) {
            Point p = pq.poll();
            ret[i][0] = p.x();
            ret[i][1] = p.y();
        }
        return ret;
    }
}
