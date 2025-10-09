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
    /*
     public List<Integer> rightSideView(TreeNode root) { //bfs
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                
                // if it's the last node in this level, add to result
                if (i == size - 1) {
                    result.add(node.val);
                }
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        
        return result;
    }

    */
    public List<Integer> rightSideView(TreeNode root) { //dfs
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