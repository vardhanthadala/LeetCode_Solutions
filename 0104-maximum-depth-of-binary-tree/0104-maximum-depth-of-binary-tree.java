class Solution {
    public int maxDepth(TreeNode root) {
        int max=0;
        if(root==null) return 0;

    //recurrsively finding depth of left and right node
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}