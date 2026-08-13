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
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode left = head;
        ListNode right = head;
        ListNode prevHead = dummy;
        
        while(right != null) {
            int i = 0;
            while(i<k && right != null) {
                right = right.next;
                i++;
            }
            if(i < k) break;
            reverseTillNodeAndReturnHead(left, right, prevHead);
            prevHead = left;
            left = right;
        }

        return dummy.next;
    }

    ListNode reverseTillNodeAndReturnHead(ListNode starter, ListNode till, ListNode prevHead) {
        ListNode prev = till;
        ListNode start = starter;
        while(start != null && start != till) {
            ListNode next = start.next;
            start.next = prev;
            prev = start;
            start = next;
        }
        prevHead.next = prev;
        return prev;
    }
}
