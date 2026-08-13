class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();

        for(Integer i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int lengthOfBuckets = nums.length + 1;
        List<Integer>[] buckets = new List[lengthOfBuckets];

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if(buckets[value] == null) {
                buckets[value] = new ArrayList<>();
            }
            buckets[value].add(entry.getKey());
        }

        int[] kelements = new int[k];
        int index = 0;
        for(int i=nums.length; i >= 0 && index < k; i--) {
            if(buckets[i] == null) continue;
            for(int num : buckets[i])  {
                kelements[index++] = num;
                if(index == k) break;
            }
        }

        return kelements;
    }
}
