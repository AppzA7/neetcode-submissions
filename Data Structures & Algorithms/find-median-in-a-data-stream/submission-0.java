class MedianFinder {

    PriorityQueue<Integer> maxHeap= new PriorityQueue<>((a,b) -> b.compareTo(a));
    PriorityQueue<Integer> minHeap= new PriorityQueue<>();
    
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);

        minHeap.offer(maxHeap.poll());

        if(minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()) return maxHeap.peek();
        return ((double) minHeap.peek() + maxHeap.peek())/2;
    }

}
