package cn.abelib.two;

/**
 * @Author: abel.huang
 * @Date: 2019-02-28 14:53
 */
public class InvertBinaryTree226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        TreeNode temp =  root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
