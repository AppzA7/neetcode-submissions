/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToNewMap = new HashMap<>();

        Node nItr = head;
        while(nItr != null) {
            // create new node and hash
            oldToNewMap.put(nItr, new Node(nItr.val));
            nItr = nItr.next;
        }

        nItr = head;
        while(nItr != null) {
            Node tNode = oldToNewMap.get(nItr);
            tNode.next = oldToNewMap.get(nItr.next);
            tNode.random = oldToNewMap.get(nItr.random);
            nItr = nItr.next;
        }

        return oldToNewMap.get(head);
    }
}
