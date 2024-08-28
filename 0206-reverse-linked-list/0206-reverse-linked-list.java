
class Solution {
    public ListNode reverseList(ListNode head) {
      ListNode prev = null; // The previous node, initially null
        ListNode current = head; // The current node, initially the head of the list

        while (current != null) {
            ListNode nextNode = current.next; // Temporarily store the next node
            current.next = prev; // Reverse the current node's pointer to the previous node
            prev = current; // Move the previous node to the current node
            current = nextNode; // Move to the next node in the original list
        }

        return prev; // At the end, prev will be the new head of the reversed list
    }
}