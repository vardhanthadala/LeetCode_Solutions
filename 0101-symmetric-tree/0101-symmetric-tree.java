class Solution {
    // public boolean isSymmetric(TreeNode root) {//recursion
    //     if (root == null) {
    //         return true;
    //     }
    //     return isMirror(root.left, root.right);
    // }

    // private boolean isMirror(TreeNode node1, TreeNode node2) {
    //     if (node1 == null && node2 == null) {
    //         return true;
    //     }
    //     if (node1 == null || node2 == null) {
    //         return false;
    //     }
    //     return node1.val == node2.val && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    // }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);

        while (!q.isEmpty()) {
            TreeNode a = q.poll();
            TreeNode b = q.poll();

            if (a == null && b == null) {//If both nodes are null, skip this pair and move on to the next.
                continue;
            }
            if (a == null || b == null) {
                return false;
            }
            if (a.val != b.val) {
                return false;
            }
            /*

           Left’s left ↔ Right’s right
           Left’s right ↔ Right’s left

           */
            q.add(a.left);
            q.add(b.right);
            q.add(a.right);
            q.add(b.left);

        }
        return true;

    }
}