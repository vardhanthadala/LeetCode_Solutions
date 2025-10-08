class Solution {
    // public TreeNode invertTree(TreeNode root) {
    //     if(root == null)  return null;

    //     TreeNode temp=root.left;
    //     root.left=root.right;
    //     root.right=temp;

    //     //tell the recursion to do the same operation (swap children) on both the left and right subtrees.
    //     invertTree(root.left);
    //     invertTree(root.right);

    //     return root;
    // }
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        Queue<TreeNode>q= new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right =temp;

            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
        return root;

    }
}