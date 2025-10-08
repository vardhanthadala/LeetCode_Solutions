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
    // public List<Integer> inorderTraversal(TreeNode root) {//recursive

    // if(root == null){
    // return new ArrayList<Integer>();
    // }

    // ArrayList<Integer> ans = new ArrayList<>();
    // ans.addAll(inorderTraversal(root.left));

    // ans.add(root.val);

    // ans.addAll(inorderTraversal(root.right));

    // return ans;
    // }
    public List<Integer> inorderTraversal(TreeNode root) {//iterative
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // process node
            curr = stack.pop();
            inorder.add(curr.val);

            //move to right sub tree
            curr = curr.right;
        }
        return inorder;
    }
}