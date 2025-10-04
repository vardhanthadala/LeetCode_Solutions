/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
    node.val=node.next.val;//Copy next node’s value
    node.next=node.next.next;  
    }
}

 /** [a,b,c,d] thn node = b
  To remove b we should store c in b --> [ a,c,c,d] --> node.val = node.next.val
  then remove the first c --> [a,c,b]-->node.next=node.next.next
  

  */
