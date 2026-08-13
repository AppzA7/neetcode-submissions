/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode iterator = dummy;
        ListNode nTracker = dummy;
        int nCounter = 0;
        // d 1 2 3 4
        // n = 2
        //    

        // d 1 n
        //  
        while(iterator != null) {
            if(nCounter > n) {
                nTracker = nTracker.next;
            }
            nCounter++;
            iterator = iterator.next;
        }
        // remove node
        nTracker.next = nTracker.next.next;
        return dummy.next;
    }
}
