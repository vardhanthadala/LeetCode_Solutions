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
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || k == 0) {
            return head;
        }

        ListNode tail = head;
        int length = 1;

        // 1.Find length
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        if (k % length == 0) { // multiples of k gives same LL(Handling full rotations)
            return head;
        }

        //2.Connect tail to head it becomes circular list
        tail.next = head;
        //3.Find new head after rotation
        k = k % length;
        int stepsToNewHead = length - k; 

        ListNode newTail = tail;
        for (int i = 0; i < stepsToNewHead; i++) { //iterate till len-k
            newTail = newTail.next;
        }

        // 4. Break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

}