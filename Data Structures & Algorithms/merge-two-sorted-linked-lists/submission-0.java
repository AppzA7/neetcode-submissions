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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // insert in front
        // t = cur->next
        // cur->next = new 
        // new = new->next
        // cur->next->next = t;

        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode merged = null;
        ListNode mergedTracker = merged;
        while(list1 != null && list2 != null) {
            ListNode curList = null;
            if(list1.val < list2.val) {
                curList = list1;
                list1 = list1.next;
            } else {
                curList = list2;
                list2 = list2.next;
            }

            curList.next = null;
            if(mergedTracker == null) {
                merged = curList;
                mergedTracker = merged;
            } else {
                mergedTracker.next = curList;
                mergedTracker = mergedTracker.next;
            }
        }

        while(list1 != null) {
            mergedTracker.next = list1;
            list1 = list1.next;
            mergedTracker = mergedTracker.next;
        }

        while(list2 != null) {
            mergedTracker.next = list2;
            list2 = list2.next;
            mergedTracker = mergedTracker.next;
        }

        return merged;

    }
}