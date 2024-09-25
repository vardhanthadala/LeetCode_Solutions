
class Solution {
    // iterative approach //
    // time->O(n) space ->O(1)

    // public ListNode reverseList(ListNode head) {
    // ListNode prev = null;
    // ListNode current = head;

    // while (current != null) {
    // ListNode nextNode = current.next;
    // current.next = prev;
    // prev = current;
    // current = nextNode;
    // }

    // return prev;
    // }

    // Recursive approach
    // time->O(n) space->O(n)
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode head2 = reverseList(head.next);
        head.next.next = head;
        head.next = prev;
        return head2;
    }
}