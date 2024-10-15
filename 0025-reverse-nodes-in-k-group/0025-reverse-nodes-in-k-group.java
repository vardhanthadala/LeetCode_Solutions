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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevLast = null;// to track the last node of the previous group
        while (temp != null) {
            ListNode KthNode = getKthNode(temp, k);

            if (KthNode == null) { // not a complete group of k nodes
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                break;

            }

            ListNode nextNode = KthNode.next;// Store the next node after the Kth node

            KthNode.next = null;// Disconnect the Kth node to prepare for reversal

            reverseLL(temp);// revese the nodes from temp to Kth node

            if (temp == head) {// Adjust the head if the reversal starts from the head
                head = KthNode;
            } else {
                // Link the last node of the previous group to the reversed group
                prevLast.next = KthNode;
            }

            // Update the pointer to the last node of the previous group
            prevLast = temp;

            // Move to the next group
            temp = nextNode;
        }
        return head;

    }

    private ListNode reverseLL(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = prev;

            prev = temp;
            temp = next;
        }
        return prev;
    }

    private ListNode getKthNode(ListNode temp, int k) {

        while (temp != null && k > 1) {
            temp = temp.next;
            k--;

        }
        return temp;
    }
}