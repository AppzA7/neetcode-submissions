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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode result = new ListNode(0);
        ListNode resultItr = result;
        ListNode l1itr = l1, l2itr = l2;
        while(l1itr != null && l2itr != null) {
            int sumResult = l1itr.val + l2itr.val + carry;
            resultItr.next = new ListNode(sumResult % 10);
            carry = sumResult / 10;
            l1itr = l1itr.next;
            l2itr = l2itr.next;
            resultItr = resultItr.next;
        }
        while(l1itr != null) {
            int sumResult = l1itr.val + carry;
            resultItr.next = new ListNode(sumResult % 10);
            carry = sumResult / 10;
            l1itr = l1itr.next;
            resultItr = resultItr.next;
        }
        while(l2itr != null) {
            int sumResult = l2itr.val + carry;
            resultItr.next = new ListNode(sumResult % 10);
            carry = sumResult / 10;
            l2itr = l2itr.next;
            resultItr = resultItr.next;
        }
        if(carry != 0) {
            resultItr.next = new ListNode(carry);
        }
        return result.next;
    }
}
