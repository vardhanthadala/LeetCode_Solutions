/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // public int sumOfLeftLeaves(TreeNode root) {//dfs recursion
    //     if (root == null) {
    //         return 0;
    //     }
    //     int sum = 0;

    //     if (root.left != null && root.left.left == null && root.left.right == null) {
    //         sum += root.left.val;

    //     }
    //     sum += sumOfLeftLeaves(root.left);
    //     sum += sumOfLeftLeaves(root.right);
    //     return sum;

    // }
    public int sumOfLeftLeaves(TreeNode root) {//bfs
        if (root == null)
            return 0;
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    sum += node.left.val;
                } else {
                    queue.offer(node.left);
                }
            }
            if (node.right != null)
                queue.offer(node.right);
        }

        return sum;

    }
}