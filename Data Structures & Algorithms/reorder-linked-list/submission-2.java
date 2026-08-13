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
    public void reorderList(ListNode head) {
        // find middle
        // reverse second half
        // merge with first

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //terminate first half
        // reverse list from slow->next

        ListNode p = null;
        fast = slow.next;
        slow.next = p; // terminate first list
        while(fast != null) {
            ListNode t = fast.next;
            fast.next = p;
            p = fast;
            fast = t;
        }

        ListNode secondHalf = p;
        ListNode firstHalf = head;

        while(secondHalf != null) {
            ListNode secondNext = secondHalf.next;
            ListNode firstNext = firstHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = firstNext;

            firstHalf = firstNext;
            secondHalf = secondNext;
        }
        // second half ends in null
    }
}
