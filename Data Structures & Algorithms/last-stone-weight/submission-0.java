class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> stoneQ = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones) {
            stoneQ.offer(stone);
        }

        while(!stoneQ.isEmpty()) {
            if(stoneQ.size() == 1) return stoneQ.poll();
            int newStone = Math.abs(stoneQ.poll() - stoneQ.poll());
            if(newStone != 0) {
                stoneQ.offer(newStone);
            }
        }
        return 0;
    }
}
