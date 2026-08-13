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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tailItr = head;
        ListNode tailItrPrev = null;
        ListNode headItr = head;
        int i;
        for(i=0;i<k;i++) {
            tailItrPrev = tailItr;
            tailItr = tailItr.next;
        }

        // reverse from headItr to tailItrPrev
        ListNode previousTail = headItr;
        reverseTillNode(headItr, tailItrPrev);
        // headItr.next = tailItr;previousTail.next = tailItr; 
        previousTail.next = tailItr; 
        ListNode newHead = tailItrPrev;
        

        while(tailItr != null) {
            headItr = tailItr;
            for(i=0;i<k && tailItr != null;i++) {
                tailItrPrev = tailItr;
                tailItr = tailItr.next;
            }
            if( i < k ) {
                previousTail.next = headItr;
                return newHead;
            }
            ListNode reversedHead = reverseTillNode(headItr, tailItrPrev);
            previousTail.next = reversedHead;
            previousTail = headItr;
        }
        return newHead;
    }

    public ListNode reverseTillNode(ListNode starter, ListNode till) {
        ListNode next = null;
        ListNode start = starter;
        ListNode prev = null;
        while(prev != till) {
            next = start.next;
            start.next = prev;
            prev = start;
            start = next;
        }
        return prev;
    }
}
