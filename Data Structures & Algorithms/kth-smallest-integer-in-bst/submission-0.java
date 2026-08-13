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
    int current = 0;
    public int kthSmallest(TreeNode root, int k) {
        return dfs(root, k, -1);
    }

    public int dfs(TreeNode root, int k, int val) {
        if(root == null) return 0;
        if(current == k) return val;

        int left = dfs(root.left, k, val);
        if(current == k) return left;

        current++;
        if(current == k) return root.val;
        
        int right = dfs(root.right, k, left);
        if(current == k) return right;

        return val;
    }
}
