class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // use bucket sort
        List<Integer>[] buckets = new List[nums.length];

        // O(n)
        for(int i=0;i<nums.length;i++) {
            buckets[i] = new ArrayList<>();
        } 

        Map<Integer, Integer> countMap = new HashMap<>();

        // O(n)
        for(int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // put into buckets of count from map
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            buckets[entry.getValue() - 1].add(entry.getKey());
        }

        int index = 0;
        int[] res = new int[k];
    
        for(int i=nums.length - 1; i >= 0 && index < k; i--) {
            for( int n : buckets[i]) {
                res[index++] = n;
                if(index == k) {
                    return res;
                }
            }
        }
        return res;
    }

}
