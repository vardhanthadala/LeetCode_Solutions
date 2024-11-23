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
class BSTIterator {
    private TreeNode current;
    private TreeNode lastVisited;

    public BSTIterator(TreeNode root) {
        current = root;
        lastVisited = null;
    }

    public int next() {
        while (current != null) {
            if (current.left == null) {
                // No left child, visit current node
                int value = current.val;
                lastVisited = current;
                current = current.right;
                return value;
            } else {
                // Find the in-order predecessor
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    // Create the thread and move to the left subtree
                    predecessor.right = current;
                    current = current.left;
                } else {
                    // Thread exists, break it, visit current node
                    predecessor.right = null;
                    int value = current.val;
                    lastVisited = current;
                    current = current.right;
                    return value;
                }
            }
        }

        return -1; // Should not happen if next() is called correctly
    }

    public boolean hasNext() {
        return current != null;
    }
}


/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */