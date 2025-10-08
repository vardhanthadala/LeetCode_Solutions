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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();

        nodeQueue.add(root);
        pathQueue.add(String.valueOf(root.val));

        while (!nodeQueue.isEmpty()) {
            TreeNode current = nodeQueue.poll();
            String path = pathQueue.poll();

            // Leaf node → add path
            if (current.left == null && current.right == null) {
                result.add(path);
            }

            if (current.left != null) {
                nodeQueue.add(current.left);
                pathQueue.add(path + "->" + current.left.val);
            }

            if (current.right != null) {
                nodeQueue.add(current.right);
                pathQueue.add(path + "->" + current.right.val);
            }
        }

        return result;
    }
}
