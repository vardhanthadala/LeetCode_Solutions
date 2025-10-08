class Solution {
    // public int maxDepth(TreeNode root) {//recursive
    // int max=0;
    // if(root==null) return 0;

    // //recurrsively finding depth of left and right node
    // return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    // }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        int level = 0;

        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {//if we dont use for loop level++ would increment for every node, not for every level.
                TreeNode node = q.poll();
                // Add left child if exists
                if (node.left != null) {
                    q.add(node.left);
                }

                // Add right child if exists
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            level++;
        }

        return level;
    }
}