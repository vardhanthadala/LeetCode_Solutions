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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>(); // List that stores all nodes

        if (root == null) { // if tree is empty return empty list
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();// create a queue to store nodes for level order traversal
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            List<Integer> level = new ArrayList<>();// list to store nodes at current level
            for (int i = 0; i < size; i++) {
                // Get the front node in the queue
                TreeNode node = q.poll();

                level.add(node.val);

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}