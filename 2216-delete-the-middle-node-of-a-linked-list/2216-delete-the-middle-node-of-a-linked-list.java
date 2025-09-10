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
    public ListNode deleteMiddle(ListNode head) {
        if(head==null||head.next==null){
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null; //used to track node before slow pointer

        while(fast!=null && fast.next!=null){
            prev=slow; //it has node of before the slow pointer
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=slow.next;//removing mid element which is at slow pointer node 

        return head;
    }
}