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
    public record rec(int maxPath, int maxPathSum) {};
    public int maxPathSum(TreeNode root) {
        rec val = helper(root);
        return Math.max(val.maxPath(), val.maxPathSum());
    }

    public rec helper(TreeNode root) {
        if(root == null) return new rec(-1001, -1001);
        rec left = helper(root.left);
        rec right = helper(root.right);
        int pathSum = root.val;
        if(left.maxPath > 0) pathSum += left.maxPath;
        if(right.maxPath > 0) pathSum += right.maxPath;
    
        int maxPathSumVal = Math.max(left.maxPathSum(), right.maxPathSum());
        maxPathSumVal = Math.max(pathSum, maxPathSumVal);
        return new rec(Math.max(0, Math.max(left.maxPath(), right.maxPath())) + root.val, maxPathSumVal);
    }
}
