class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0] - b[0]);
        Map<Integer, Integer> countMap = new HashMap<>();

        for(int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            minHeap.offer(new int[] {entry.getValue(), entry.getKey()});
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        for(int i=0;i<k;i++) {
            res[i] = minHeap.poll()[1];
        }
        return res;
    }

}
