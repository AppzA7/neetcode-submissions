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
    public int diameterOfBinaryTree(TreeNode root) {
        // diameter = max diameter of children
        // or maxlongest path of left child + longest path of right child
        // return max(LpaLc, LpaRc) and above,
        Map.Entry<Integer, Integer> data = diameterHelper(root);
        return data.getValue();
    }

    public Map.Entry<Integer, Integer> diameterHelper(TreeNode root) {
        if(root == null) return new AbstractMap.SimpleEntry<>(0,0);
        Map.Entry<Integer, Integer> left = diameterHelper(root.left);
        Map.Entry<Integer, Integer> right = diameterHelper(root.right);

        // key = longest path
        // value = max dia

        int maxDia = Math.max(left.getValue(), right.getValue());
        maxDia = Math.max(maxDia, left.getKey() + right.getKey());

        int maxPath = 1 + Math.max(left.getKey(), right.getKey());
        return new AbstractMap.SimpleEntry<>(maxPath, maxDia);
    }
}
