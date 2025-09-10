/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        for (int i = 0; i < n; i++) { //Fast moves till n
            fast = fast.next;
        }
        if (fast == null) {//if given list size and n is same then fast will be at null...so remove head and return head.next
            return head.next;
        }
        while (fast.next != null) { //move slow and fast pointer by one - one step
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;// skipping the n value(deleting the n)

        return head;

    }
}