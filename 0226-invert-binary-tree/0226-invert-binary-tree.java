class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)  return null;

        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;

        //Recursively Invert Left Subtree
        invertTree(root.left);
        //Recursively Invert Right Subtree
        invertTree(root.right);

        return root;
    }
}