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
    Map<Integer, Integer> positionMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        positionMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++) {
            positionMap.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, inorder.length, 0);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int il, int ir, int pi) {
        if(il >= ir) return null;
        TreeNode root = new TreeNode(preorder[pi]);
        int i = positionMap.get(preorder[pi]);
        root.left = helper(preorder, inorder, il, i, pi+1);
        // pi increases by left size since those many elements were processed;
        root.right = helper(preorder, inorder, i+1, ir, pi + (i - il) + 1);
        return root;
    }
}
