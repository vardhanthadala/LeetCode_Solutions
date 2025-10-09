class Solution {
    // public boolean hasPathSum(TreeNode root, int targetSum) {//Space Complexity: O(h)
    //     if(root == null){ 
    //         return false;
    //     }

    //     // If it's a leaf node, check if the current sum equals the targetSum
    //     if (root.left == null && root.right == null) {
    //         return targetSum == root.val;
    //     }

    //     return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val); // traverse left and right
    // }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        // Queue will hold pairs: (node, currentSum)
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();

        nodeQueue.add(root);
        sumQueue.add(root.val);

        while (!nodeQueue.isEmpty()) {
            TreeNode curr = nodeQueue.poll();
            int currSum = sumQueue.poll();

            // If it's a leaf node, check if sum matches
            if (curr.left == null && curr.right == null) {
                if (currSum == targetSum) {
                    return true;
                }
            }

            // If left child exists, add it with updated sum
            if (curr.left != null) {
                nodeQueue.add(curr.left);
                sumQueue.add(currSum + curr.left.val);
            }

            // If right child exists, add it with updated sum
            if (curr.right != null) {
                nodeQueue.add(curr.right);
                sumQueue.add(currSum + curr.right.val);
            }
        }
        return false;

    }
}
