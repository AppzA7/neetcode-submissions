class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Heap<Integer, Pair<Integer, Integer>> maxHeap = new Heap<>(nums.length);
        Map<Integer, Pair<Integer, Integer>> map = new HashMap<>();

        for(int num : nums) {
            if(map.containsKey(num)) {
                System.out.println("Increasing existing value");
                map.get(num).incSecond();
                System.out.println("new valuie : " + map.get(num));
                maxHeap.heapify(map.get(num));
            } else {
                Pair<Integer, Integer> p = new Pair(num, 1);
                map.put(num, p);
                maxHeap.add(p);
            }
        }

        int[] a = new int[k];

        while(k > 0) {
            a[k-1] = maxHeap.popTop().getFirst();
            k--;    
        }
        return a;
    }

    class Pair<U, V extends Comparable> implements Custom<U, Pair<U, V>> {
        U first;
        V second;

        public Pair(U f, V s) {
            first = f;
            second = s;
        };

        @Override
        public int compareTo(Pair<U, V> other) {
            return second.compareTo(other.getSecond());
        }

        public V getSecond() {
            return second;
        }

        public U getFirst() {
            return first;
        }

        public void incSecond() {
            if ( second instanceof Integer s) {
                s++;
                System.out.println("Second increased to " + s);
                second = (V) s;
            }
        }

        @Override
        public String toString() {
            return "(" + first + "," + second + ")";
        }
    }

    interface Custom<T, U> extends Comparable<U> {
        public T getFirst();
    }

    class Heap<U, T extends Custom<U, T>> {
        List<T> items;
        int size;
        Map<U, Integer> itemIndexMap;
        public Heap() {
            
        }

        public Heap(int size) {
            items = new ArrayList<>(size);
            size = 0;
            itemIndexMap = new HashMap<>();
        }

        public void heapify(int index) {
            System.out.println("Heapifying at index " + index);
            T el = items.get(index);
            int parent = (index - 1)/ 2;
            while(parent >= 0 && el.compareTo(items.get(parent)) > 0) {
                System.out.println("trickle up");
                Collections.swap(items, index, parent);
                itemIndexMap.put(items.get(parent).getFirst(), parent);
                itemIndexMap.put(items.get(index).getFirst(), index);
                index = parent;
                parent = (parent-1) / 2;
                System.out.println("current heap after trickle step " +  items);
            }

        }

        public void heapify(T item) {
            int fromIndex = itemIndexMap.get(item.getFirst());
            heapify(fromIndex);
            System.out.println("Final Heap after heapify : " + items);
        }   

        public void add(T el) {
            System.out.println("Adding");
            items.add(el);
            itemIndexMap.put(el.getFirst(), size);
            size++;
            int index = size - 1;
            int parent = (index - 1)/ 2;
            while(parent >= 0 && el.compareTo(items.get(parent)) > 0) {
                System.out.println("trickle up");
                Collections.swap(items, index, parent);
                itemIndexMap.put(items.get(parent).getFirst(), parent);
                itemIndexMap.put(items.get(index).getFirst(), index);
                index = parent;
                parent = (parent-1) / 2;
                System.out.println("current heap after trickle step " +  items);
            }
            System.out.println("Final heap after add: " + items);
        }

        public T popTop() {
            System.out.println("size : " + size);
            T top = items.get(0);
            
            Collections.swap(items, 0, size-1);
            items.remove(size-1);
            size--;
            if(size == 0) return top;
            itemIndexMap.remove(top);
            // trickle down
            T toTrickle = items.get(0);
            int index = 0;
            while(true) {
                int childi = index * 2 + 1;
                if(childi < items.size()) {
                    T child = items.get(childi);
                    if( childi + 1 < items.size()) {
                        T child2 = items.get(childi + 1);
                        if(child.compareTo(child2) < 0) {
                            child = child2;
                            childi = childi + 1;
                        }                        
                    }
                    if(child.compareTo(toTrickle) > 0) {
                        Collections.swap(items, index, childi);
                        itemIndexMap.put(items.get(index).getFirst(), index);
                        itemIndexMap.put(items.get(childi).getFirst(), childi);
                        index = childi;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            System.out.println("Heap after popTop" + items);
            return top;
        }
    }
}
