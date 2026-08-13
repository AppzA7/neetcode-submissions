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
        Node itr = head;

        if(head == null) return null;
        
        while(itr != null) {
            Node newNode = new Node(itr.val);
            newNode.next = itr.next;
            newNode.random = itr.random;
            itr.next = newNode;
            itr = newNode.next;
        }

        // restore random pointers
        itr = head.next;
        while(itr != null) {
            itr.random = itr.random != null ? itr.random.next : null;
            itr = itr.next != null ? itr.next.next : null;
        }

        // separate links
        itr = head;
        Node newList = head.next;
        while(itr != null) {
            Node copy = itr.next;
            itr.next = copy.next;
            copy.next = copy.next != null ? copy.next.next : null;
            itr = itr.next;
        }
        return newList;
    }
}
