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
    record Pair(boolean foundFirst, boolean foundSecond) {};

    TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca = null;
        helper(root, p, q);
        return lca;
    }

    public Pair helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return new Pair(false, false);
        Pair left = helper(root.left, p, q);
        if(left.foundFirst() && left.foundSecond()) { 
            lca = (lca == null) ? root.left : lca;
            return new Pair(true, true);
        }
        Pair right = helper(root.right, p, q);
        if(right.foundFirst() && right.foundSecond()) { 
            lca = (lca == null) ? root.right : lca;
            return new Pair(true, true);
        }

        boolean isFirst = ((root.val == p.val) || left.foundFirst() || right.foundFirst()) ;
        boolean isSecond = ((root.val == q.val) || left.foundSecond() || right.foundSecond());

        if(isFirst && isSecond) {
            if(lca == null) lca = root;
            return new Pair(true, true);
        }

        return new Pair(isFirst, isSecond);
    }

}
