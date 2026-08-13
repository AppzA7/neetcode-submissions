class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean visited[] = new boolean[n];

        int cost[] = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = 0;

        int totalCost = 0;
        for(int connectedVertices = 0; connectedVertices < n; connectedVertices++) {
            int minIndex = -1;
            
            // choose min cost vertex from unvisited visited nodes
            for(int i=0;i<n;i++) {
                if(
                    !visited[i] && 
                    (minIndex == -1 || cost[i] < cost[minIndex])
                ) {
                    minIndex = i;
                }
            }

            visited[minIndex] = true;
            totalCost += cost[minIndex];

            for(int i=0;i<n;i++ ){
                if(!visited[i]) {
                    int length = 
                        Math.abs(points[minIndex][1] - points[i][1]) 
                        + Math.abs(points[minIndex][0] - points[i][0]);
                    cost[i] = Math.min(cost[i], length);
                }
            }
        }

        return totalCost;
        /*
            index     0    1    2    3    4       
            points    0,0  2,2  3,3  2,4  4,2
            cost      0    4    2    M    M
            visited   1    1    1    0    0
            connectedEdges: 2
            totalCost = 6
        */
    }
}
