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
        // find mid of linked list, reverse it and then merge with previous half
        if (head == null) return;
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        };

        // reverse slow.next;

        ListNode iterator = slow.next;
        slow.next = null;

        ListNode prev = null;

        while(iterator != null) {
            ListNode tnext = iterator.next;
            iterator.next = prev;
            prev = iterator;
            iterator = tnext;
        }

        // prev is start reversed list

        ListNode dummy = new ListNode();
        iterator = dummy;

        ListNode first = head, second = prev;
        while(first != null) {
            dummy.next = first;
            dummy = dummy.next;
            first = first.next;
            if(second != null) {
                dummy.next = second;
                dummy = dummy.next;
                second = second.next;
            }
        }

        head = dummy.next;
    }
}
