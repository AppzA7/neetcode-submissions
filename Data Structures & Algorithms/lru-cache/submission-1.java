class LRUCache {
    // used linked list for least recently used
    // use map for lookup
    class Node {
        int key;
        int val;
        Node left;
        Node right;

        public Node(int key, int val) {
            this.val = val;
            this.key = key;
        }

        public String toString() {
            return "Key : " + key + ", Value : " + val;
        }
    };

    Node HEAD, TAIL, NULL;

    void addToFront(Node val) {
        if(val == HEAD || val == TAIL) return;
        // System.out.println("Adding to front " + val);
        Node tr = HEAD.right;
        HEAD.right = val;
        val.left = HEAD;
        val.right = tr;
        tr.left = val;
    }

    void removeNode(Node val) {
        if(val == HEAD || val == TAIL) return;
        // System.out.println("Removing node " + val);
        Node leftN = val.left;
        Node rightN = val.right;
        if(leftN != null)
            leftN.right = rightN;
        if(rightN != null)
            rightN.left = leftN;

    }


    int capacity;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        HEAD = new Node(-1,-1);
        TAIL = new Node(-1,-1);
        NULL = new Node(-1, -1);
        HEAD.right = TAIL;
        TAIL.left = HEAD;
    }
    
    public int get(int key) {
        Node used = map.getOrDefault(key, NULL);
        if(used == NULL) return -1;
        removeNode(used);
        addToFront(used);
        return used.val;
    }
    
    public void put(int key, int value) {
        Node toAdd;
        if(map.containsKey(key)) {
            toAdd = map.get(key);
            toAdd.val = value;
            removeNode(toAdd);
            addToFront(toAdd);
        } else {
            toAdd = new Node(key, value);
            if(map.size() == capacity) {
                // pop last, add new
                Node toRemove = TAIL.left;
                removeNode(toRemove);
                map.remove(toRemove.key);
            }
            addToFront(toAdd);
            map.put(key, toAdd);
        }
    }
}
