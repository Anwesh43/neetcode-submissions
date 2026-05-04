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
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        ListNode next = curr.next;
        curr.next = null;
        while (next != null) {
            ListNode next2 = next.next;
            next.next = curr;
            curr = next;
            next = next2;
        }
        return curr;
    }
}
// 0 -> 1 -> 2 -> 3 -> 4

// 4 -> 3 -> 2 -> 1 -> 0


// 0 , 1 2 

// 0 1