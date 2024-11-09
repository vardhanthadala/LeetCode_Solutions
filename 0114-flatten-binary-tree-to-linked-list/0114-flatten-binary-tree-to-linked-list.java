/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    // 1.Recursion O(N) O(N)
    //// if prev=null assigned in the method then it causes it to reset to null on
    // each call

    // TreeNode prev=null;
    // public void flatten(TreeNode root) {
    // if(root==null){
    // return;
    // }
    // flatten(root.right);
    // flatten(root.left);

    // root.right=prev;
    // root.left=null;
    // prev=root;
    // }

    //Iterative approach O(N)  O(1)
    public void flatten(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                // Find the rightmost node in the left subtree
                TreeNode prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }

                // Link the right subtree of curr to the rightmost node of the left subtree
                prev.right = curr.right;

                // Move the left subtree to the right and set left to null
                curr.right = curr.left;
                curr.left = null;
            }

            // Move to the next node (current right)
            curr = curr.right;
        }
    }
}