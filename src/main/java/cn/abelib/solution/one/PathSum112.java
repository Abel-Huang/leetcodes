package cn.abelib.solution.one;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author abel-huang
 * @date 2016/8/9
 * Use a hashmap to save every node path's sum, if
 * the node is the leaf, confirm if the sum is equals to
 * the target.
 */
public class PathSum112 {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.left.left=new TreeNode(2);
//        root.left.right=new TreeNode(2);
//        root.right=new TreeNode(3);
//        root.right.left=new TreeNode(2);
//        root.right.right=new TreeNode(2);
        int sum = 3;
        System.out.print(hasPathSum(root, sum));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        Map<TreeNode, Integer> hashMap = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return false;
        }
        stack.push(root);
        hashMap.put(root, root.val);
        while (!stack.empty()) {
            root = stack.pop();
            if (root.right != null) {
                stack.push(root.right);
                hashMap.put(root.right, hashMap.get(root) + root.right.val);
            }
            if (root.left != null) {
                stack.push(root.left);
                hashMap.put(root.left, hashMap.get(root) + root.left.val);
            }
            if (root.left == null && root.right == null) {
                if (hashMap.get(root) == sum) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else if(root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        return hasPathSum2(root.left, sum - root.val) || hasPathSum2(root.right, sum - root.val);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
