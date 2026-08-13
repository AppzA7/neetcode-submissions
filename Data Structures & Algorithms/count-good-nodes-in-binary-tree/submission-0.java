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
    int maxSoFar = -101;
    int count = 0;
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            if(root.val >= maxSoFar) {
                count++;
            }
            return count;
        }

        if(maxSoFar <= root.val) {
            count++;
        }
        int prevMaxSoFar = maxSoFar;
        maxSoFar = Math.max(root.val, maxSoFar);
        goodNodes(root.left);
        goodNodes(root.right);
        if(prevMaxSoFar < root.val)
            maxSoFar = prevMaxSoFar;
        return count;
    }

}
