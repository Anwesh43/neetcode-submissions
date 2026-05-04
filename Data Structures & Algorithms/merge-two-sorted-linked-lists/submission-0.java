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
        ListNode head = null, curr = null;
        while (list1 != null && list2 != null) {
            ListNode toGoNext = list1;
            int nodeToIncrement = 0;
            if (list1.val > list2.val) {
                toGoNext = list2;
                nodeToIncrement = 1;
            }
            if (head == null) {
                head = toGoNext;
                curr = head;
            } else {
                curr.next = toGoNext;
                curr = curr.next;
            }
            if (nodeToIncrement == 0) {
                list1 = list1.next;
            } else {
                list2 = list2.next;
            }
        }
        ListNode toGoNext = list1;
        if (list2 != null) {
            toGoNext = list2;
        }
        while (toGoNext != null) {
            if (head == null) {
                head = toGoNext;
                curr = head;
            } else {
                curr.next = toGoNext;
                curr = curr.next;
            } 
            toGoNext = toGoNext.next;
        }
        return head;
    }
}