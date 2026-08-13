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
        ListNode l1itr = l1, l2itr = l2, result = new ListNode(), resultItr = result;

        int carry = 0;
        int sum = 0;
        while(l1itr != null || l2itr != null || carry != 0) {
            sum = 0;
            if(l1itr != null) {
                sum += l1itr.val;
                l1itr = l1itr.next;
            }

            if(l2itr != null) {
                sum += l2itr.val;
                l2itr = l2itr.next;
            }

            if(carry != 0) {
                sum += carry;
            }
            carry = sum / 10;
            resultItr.next = new ListNode(sum % 10);
            resultItr = resultItr.next;
        }
        return result.next;
    }
}
