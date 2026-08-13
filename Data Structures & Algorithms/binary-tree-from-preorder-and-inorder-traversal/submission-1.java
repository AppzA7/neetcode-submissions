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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, inorder.length, 0);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int il, int ir, int pi) {
        if(il >= ir || pi >= preorder.length) return null;
        TreeNode root = new TreeNode(preorder[pi]);
        int i;
        for(i=il; i < ir; i++) {
            if(preorder[pi] == inorder[i]) break;
        }
        root.left = helper(preorder, inorder, il, i, pi+1);
        // pi increases by left size since those many elements were processed;
        root.right = helper(preorder, inorder, i+1, ir, pi + (i - il) + 1);
        return root;
    }
}
