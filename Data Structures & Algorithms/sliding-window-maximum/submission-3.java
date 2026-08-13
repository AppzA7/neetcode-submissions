class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int size = nums.length - k + 1;
        int[] maximums = new int[size];

        LazyDeleteQueue<Integer> maxHeap = new LazyDeleteQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<k-1;i++) {
            maxHeap.add(nums[i]); // all till k-1. kth will be added in next loop
        }

        for(int i=k-1;i<nums.length; i++) {
            //add the right element
            maxHeap.add(nums[i]);
            int index = i - k + 1;
            Integer maxVal = maxHeap.top();
            // no need to handle null since that case will not occur. 
            maximums[index] = maxVal;
            //remove left from queue;
            maxHeap.delete(nums[index]);
        }

        return maximums;
    }
}

class LazyDeleteQueue<T> {
    PriorityQueue<T> heap;
    Map<T, Integer> deletedItems;

    public LazyDeleteQueue() {}
    public LazyDeleteQueue(Comparator <? super T> comparator) {
        heap = new PriorityQueue<>(comparator);
        deletedItems = new HashMap<>();
    };

    public void add(T item) {
        heap.add(item);
    }

    public void delete(T item) {
        deletedItems.put(item, deletedItems.getOrDefault(item, 1));
    }

    public T poll() {
        while(!heap.isEmpty()) {
            T top= heap.poll();
            if(deletedItems.containsKey(top)) {
                Integer currentValue = deletedItems.get(top);
                if(currentValue == 1) {
                    deletedItems.remove(top);
                } else {
                    deletedItems.put(top, currentValue - 1);
                }
            } else {
                return top;
            }
        }
        return null;
    }

    public T top() {
        while(!heap.isEmpty()) {
            T top= heap.peek();
            if(deletedItems.containsKey(top)) {
                heap.poll();
                Integer currentValue = deletedItems.get(top);
                if(currentValue == 1) {
                    deletedItems.remove(top);
                } else {
                    deletedItems.put(top, currentValue - 1);
                }
            } else {
                return top;
            }
        }
        return null;
    }
};
