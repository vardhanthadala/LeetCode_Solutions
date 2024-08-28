
class Solution {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this .data=data;
            this.next=null;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;

    }
}