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

    // // Recursive O(N) O(H)
    // public TreeNode insertIntoBST(TreeNode root, int val) {
    //     if (root == null) {
    //         return new TreeNode(val);
    //     }
    //     if (root.val > val) {
    //         root.left = insertIntoBST(root.left, val);
    //     } else {
    //         root.right = insertIntoBST(root.right, val);
    //     }
    //     return root;
    // }

    // Iterative
    public TreeNode insertIntoBST(TreeNode root, int val) {

      if(root == null) return new TreeNode(val);
        
        TreeNode curr = root;
        
        while(true){ // running an infinity loop, look for the place for new node to add
            if(curr.val < val){
                if(curr.right != null) curr = curr.right; // update current on right
                else {
                    curr.right = new TreeNode(val); // otherwise add current of right to new value TreeNode
                    break; // breaking this infinity loop
                }
            }
            else{
                if(curr.left != null) curr = curr.left; // update current on left
                else{
                    curr.left = new TreeNode(val); // otherwise add current of left to new value TreeNode
                    break; // breaking this infinity loop
                }
            }
        }
        return root;
    }
}