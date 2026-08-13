class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        PriorityQueue<Map.Entry<Integer, Integer>> minq = 
        new PriorityQueue<>(
            Map.Entry.comparingByValue()
        );

        Map<Integer, Integer> countMap = new HashMap<>();

        for( int i : nums ) { 
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            minq.add(entry);
            if(minq.size() > k) minq.poll();
        }

        int[] kelements = new int[k];
        for(int i=0;i < k; i++) {    
            kelements[i] = minq.poll().getKey();
        }

        return kelements;
    }
}
