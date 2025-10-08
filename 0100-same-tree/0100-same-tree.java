class Solution {
    // public boolean isSameTree(TreeNode p, TreeNode q) {// recursion O(n) O(h)
    //     if (p == null && q == null) {
    //         return true;
    //     }

    //     if (p == null || q == null) {
    //         return false;
    //     }

    //     if (p.val != q.val) {
    //         return false;
    //     }

    //     return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    // }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.add(p);
        q2.add(q);

        while(!q1.isEmpty() && !q2.isEmpty()){
            TreeNode node1= q1.poll();
            TreeNode node2 = q2.poll();

            if (node1 == null && node2 == null){
                continue;
            }
             if (node1 == null || node2 == null || node1.val != node2.val){
                return false;
            }
            q1.add(node1.left);
            q1.add(node1.right);
            q2.add(node2.left);
            q2.add(node2.right);
             
        }
        return q1.isEmpty() && q2.isEmpty();

    }
}
