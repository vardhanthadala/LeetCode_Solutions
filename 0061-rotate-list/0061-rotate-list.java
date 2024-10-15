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

        if (head == null ||k==0) {
            return head;
        }

        ListNode tail = head;
        int length = 1;

        // calculating the length for making a circular loop
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
       

        if (k % length==0) { // multiples of k gives same LL
            return head;
        }
        k = k % length;


        tail.next=head; //connecting tail to head for adding nodes infront of head
        ListNode newLastNode =findNthNode(head,length-k);
        head=newLastNode.next;//new head
        newLastNode.next=null;

        return head;

    }
    private ListNode findNthNode(ListNode temp,int k){
     
        int count= 1;
        while(temp!=null){
            if(count==k) break;
            count++;

            temp=temp.next;
        }
        return temp;
    }
}