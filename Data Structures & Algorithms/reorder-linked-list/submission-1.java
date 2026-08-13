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
        Deque<ListNode> stack = new ArrayDeque<>();
        
        for(ListNode node = head; node != null; node = node.next) {
            stack.offerLast(node);
        }

        if(stack.size() <= 2) return;

        int n = stack.size();
        ListNode half = null;
        for(int i=0;i<=n/2; i++) half = stack.pollFirst();
        //terminate the first half of the list
        half.next = null;

        ListNode tracker = head;
        while(!stack.isEmpty()) {
            // take last and put after tracker
            ListNode last = stack.pollLast();
            last.next = tracker.next;
            tracker.next = last;
            tracker = last.next;
        }
    }
}
