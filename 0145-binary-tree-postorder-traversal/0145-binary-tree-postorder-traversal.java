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
    // public List<Integer> postorderTraversal(TreeNode root) {//recursive
    // if (root == null) {
    // return new ArrayList<>();
    // }
    // List<Integer> res = new ArrayList<>();
    // res.addAll(postorderTraversal(root.left));
    // res.addAll(postorderTraversal(root.right));
    // res.add(root.val);
    // return res;
    // }
    public List<Integer> postorderTraversal(TreeNode root) {// using 2 stacks
        Stack<TreeNode> stack_1 = new Stack<>();
        Stack<TreeNode> stack_2 = new Stack<>();

        List<Integer> postorder = new ArrayList<>();

        if (root == null) {
            return postorder;
        }
        stack_1.push(root);
        while (!stack_1.isEmpty()) {
            root = stack_1.pop();
            stack_2.add(root);
            // If the current node has a left child, push it onto stack_1
            if (root.left != null)
                stack_1.push(root.left);
            // If the current node has a right child, push it onto stack_1
            if (root.right != null)
                stack_1.push(root.right);
        }
        // Now, stack_2 has nodes in root-right-left order
        // Pop nodes from stack_2 and add them to the postorder list to get
        // left-right-root order
        while (!stack_2.isEmpty()) {
            postorder.add(stack_2.pop().val);
        }
        return postorder;
    }
}