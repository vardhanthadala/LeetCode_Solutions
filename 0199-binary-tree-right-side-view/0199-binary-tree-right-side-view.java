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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recursionRight(root, 0, res);
        return res;
    }

    private void recursionRight(TreeNode root, int level, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (res.size() == level) { // first time visited a level ,so add it to result
            res.add(root.val);
        }
        recursionRight(root.right, level + 1, res);
        recursionRight(root.left, level + 1, res);

    }
}


//-----------LEFT SIDE VIEW SOLUTION-----------------------//

// class Solution {
//     public List<Integer> leftSideView(TreeNode root) {
//         List<Integer> res = new ArrayList<>();
//         recursionRight(root, 0, res);
//         return res;
//     }

//     private void recursionRight(TreeNode root, int level, List<Integer> res) {
//         if (root == null) {
//             return;
//         }
//         if (res.size() == level) { // first time visited a level ,so add it to result
//             res.add(root.val);
//         }
//         recursionRight(root.left, level + 1, res);
//         recursionRight(root.right, level + 1, res);

//     }
// }