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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        // final list in lists[0]
        int interval = 1;
        while (interval < lists.length) {
            // limit = 2 * i
            for(int i = 0; i + interval < lists.length; i+= interval*2) {
                // inc = 1 => (0,1), (2,3),  (4,5)
                // inc = 2 => (0,2), (4,6),  (8,10)
                // inc = 4 => (0,4), (8,12)
                // use i and i + 2^i-i
                // store in i
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }
    ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode dummy = new ListNode();
        ListNode itr = dummy;
        while( a != null && b != null) {
            if(a.val < b.val) {
                itr.next = a;
                a = a.next;
            } else {
                itr.next = b;
                b = b.next;
            }
            itr = itr.next;
        }
        if(a != null) {
            itr.next = a;
        }
        if(b != null) {
            itr.next = b;
        }

        return dummy.next;
    }
}
