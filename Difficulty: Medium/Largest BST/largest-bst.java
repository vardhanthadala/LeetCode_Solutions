//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}


// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution {

    // Method to return the size of the largest subtree that is a BST
    static int largestBst(Node root) {
        // Call the helper function and extract the size from the result
        Pair result = largestBSTHelper(root);
        return result.size;
    }

    // Helper method to compute the size of the largest BST subtree
    private static Pair largestBSTHelper(Node root) {
        // Base case: If the root is null, it represents an empty tree (a valid BST)
        if (root == null) {
            return new Pair(0, Integer.MIN_VALUE, Integer.MAX_VALUE); // Return size=0, max=MIN, min=MAX
        }

        // Recursively find the largest BST in the left and right subtrees
        Pair left = largestBSTHelper(root.left);
        Pair right = largestBSTHelper(root.right);

        // Check if the current node satisfies the BST property with its left and right subtrees
        if (root.data > left.max && root.data < right.min) {
            // If it satisfies the BST property, calculate the size of this subtree
            return new Pair(
                left.size + right.size + 1,               // Total size of BST = size of left + size of right + 1 (current node)
                Math.max(root.data, right.max),           // Update the maximum value of this BST
                Math.min(root.data, left.min)             // Update the minimum value of this BST
            );
        } else {
            // If the current node violates the BST property, return the size of the largest BST found so far
            return new Pair(
                Math.max(left.size, right.size),          // Use the larger size from left or right subtrees
                Integer.MAX_VALUE,                        // Mark as invalid BST by setting max to MAX_VALUE
                Integer.MIN_VALUE                         // Mark as invalid BST by setting min to MIN_VALUE
            );
        }
    }
}

// Helper class to store information about a subtree
class Pair {
    int size; // Size of the largest BST subtree
    int max;  // Maximum value in the current subtree
    int min;  // Minimum value in the current subtree

    // Constructor to initialize a Pair object
    public Pair(int size, int max, int min) {
        this.size = size;
        this.max = max;
        this.min = min;
    }
}
