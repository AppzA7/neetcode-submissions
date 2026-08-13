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
    public ListNode reverseList(ListNode head) {
        ListNode newHead = head;
        ListNode prev = null;
        while(head != null) {
            newHead = head; //update tail
            // reverse links
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return newHead;
    }
}
