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
    // public List<Integer> preorderTraversal(TreeNode root) {//recursive
    // List<Integer> list = new ArrayList<>();
    // if (root == null) {
    // return list;
    // }
    // list.add(root.val);
    // list.addAll(preorderTraversal(root.left));
    // list.addAll(preorderTraversal(root.right));

    // return list;

    // }

    public List<Integer> preorderTraversal(TreeNode root) {// iteration
        List<Integer> preOrder = new ArrayList<>();
        if (root == null) {
            return preOrder;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();

        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();//pop current node
            preOrder.add(root.val);//then process it (root first)

            if (root.right != null) { 
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return preOrder;
    }
}