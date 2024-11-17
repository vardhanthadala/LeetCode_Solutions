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
    public boolean isValidBST(TreeNode root) {
        return isValidate(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean isValidate(TreeNode root, long minVal, long maxVal) {
        if (root == null) {
            return true;
        }
        if (root.val >= maxVal || root.val <= minVal) {//if node is greater than max and lesser than  min values then its not a valid BST
            return false;
        }
        return isValidate(root.left, minVal, root.val) && isValidate(root.right, root.val, maxVal);
    }
}