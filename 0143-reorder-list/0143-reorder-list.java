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
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        //Step 1 : Find the mid in the list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //Step 2 : Reverse the second half of the list
        ListNode second = slow.next;

        slow.next = null;// break the list into two halves

        ListNode node = null;

        while (second != null) {
            ListNode temp = second.next;

            second.next = node;
            node = second;
            second = temp;

        }
        // Now, the prev is the head of the reversed second half

        //Step 3 : Merge the two halves
        ListNode first = head;
        second = node;

        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
           
            first.next = second;//connect first -> second
            second.next = temp1;//connect second -> temp1
            
            //move both pointers forward
            first = temp1;
            second = temp2;

        }

    }
}