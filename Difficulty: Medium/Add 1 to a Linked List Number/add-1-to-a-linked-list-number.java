//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/


//stack over flow error for recursion on large LL

// class Solution {
//     public Node addOne(Node head) { //this is the function for add new node infront of head
//         // code here.
//         int carry=helper(head);
        
//         if(carry==1){
//             Node newNode=new Node(1);
//             newNode.next=head;
//             head=newNode;
//         }
//         return head;
//       }    
//     private static int helper(Node temp){
//         if(temp==null){ //base case in recursion
//             return 1;//returning 1 because we need to add 1 to LL
//         }
//         int carry=helper(temp.next);
//         temp.data+=carry;
        
//         if(temp.data<10){
//             return 0;
//         }
//         temp.data = 0; 
//          return 1;   
//     }
    
// }
class Solution {
    public Node addOne(Node head) {
        
        head = reverse(head);//reversing ll
        
        Node temp = head;
        int carry = 1;  // We are adding 1

        while (temp != null) {//traversing ll and adding carry
            temp.data += carry;

            if (temp.data >= 10) {
                temp.data = 0;  
                carry = 1;     
            } else {
                carry = 0;      
                break;
            }

            // If it's the last node and there's still carry, add a new node
            if (temp.next == null && carry == 1) {
                temp.next = new Node(1);
                carry = 0;
                break;
            }

            temp = temp.next;
        }

        head = reverse(head);//reverse the ll to get expected o/p
        
        return head;
    }

    private Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}
