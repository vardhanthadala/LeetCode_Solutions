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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        getLeaves(root1,leaves1);
        getLeaves(root2,leaves2);

        return leaves1.equals(leaves2);
    }
    private void getLeaves(TreeNode root, List<Integer>leaves){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){ //if its a leaf thn add to list
            leaves.add(root.val);
        }else{//else recursively move to left and right nodes till u get a leaf node
            getLeaves(root.left,leaves);
            getLeaves(root.right,leaves);
        }
    }
}