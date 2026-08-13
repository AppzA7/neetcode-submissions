class Solution {
    record Task(Character name, Integer count, Integer cooldown) implements Comparable<Task>{

        @Override
        public int compareTo(Task other) {
            return Integer.compare(other.count, count);
        }
    }

    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Task> maxQ = new PriorityQueue<>();
        Queue<Task> waitingQ = new ArrayDeque<>();

        Map<Character, Integer> taskCountMap = new HashMap<>();
        for(char task : tasks) {
            taskCountMap.put(task, taskCountMap.getOrDefault(task, 0) + 1);
        }

        // offer to max q all tasks
        for(Map.Entry<Character, Integer> entrySet : taskCountMap.entrySet()) {
            maxQ.offer(new Task(entrySet.getKey(), entrySet.getValue(), 0));
        }

        int turn = 0;
        while(!maxQ.isEmpty() || !waitingQ.isEmpty()) {
            turn++;
            // System.out.println("Turn " + turn);
            // first priority check waiting q
            while(!waitingQ.isEmpty() && waitingQ.peek().cooldown() <= turn) {
                Task fromQueue = waitingQ.poll();
                maxQ.offer(new Task(fromQueue.name(), fromQueue.count(), turn));
            }
            
            //else check maxheap
            if(!maxQ.isEmpty()) {
                Task fromHeap = maxQ.poll();
                // System.out.println("fromHeap " + fromHeap);
                if(fromHeap.count() > 1)
                    waitingQ.offer(new Task(fromHeap.name(), fromHeap.count()-1, turn+n+1));
            }
        }
        return turn;
    }
}
