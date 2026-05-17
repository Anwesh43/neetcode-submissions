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
        ListNode result = null, curr = null;
        int c = 0;
        while (l1 != null || l2 != null) {
            int valL1 = 0, valL2 = 0;
            if (l1 != null) {
                valL1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                valL2 = l2.val;
                l2 = l2.next;
            }
            int sum = valL1 + valL2 + c;
            c = sum / 10;
            int rSum = sum % 10;
            if (result == null) {
                result = new ListNode(rSum);
                curr = result;
            } else {
                curr.next = new ListNode(rSum);
                curr = curr.next;
            }
        }
        if (c != 0) {
            curr.next = new ListNode(c);
        }
        return result;
    }
}
