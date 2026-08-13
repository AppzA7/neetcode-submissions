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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        String rootString = sb.toString();
        sb.setLength(0);
        serialize(subRoot, sb);
        return rootString.contains(sb.toString());
    }

    void serialize(TreeNode root, StringBuilder sb) {
        if( root == null) {
            sb.append("#");
            return;
        }
        sb.append("^").append(root.val);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }
}
