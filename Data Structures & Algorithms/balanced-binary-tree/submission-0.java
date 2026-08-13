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
    public boolean isBalanced(TreeNode root) {
        int dep = depth(root);
        return dep != -1;
    }

    int depth(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if(leftDepth == -1 || rightDepth == -1) return -1;
        if(Math.abs(rightDepth - leftDepth) > 1) return -1;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
