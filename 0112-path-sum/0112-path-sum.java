class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){ 
            return false;
        }
        
        // If it's a leaf node, check if the current sum equals the targetSum
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val); // traverse left and right
    }
}
//Space Complexity: O(h)