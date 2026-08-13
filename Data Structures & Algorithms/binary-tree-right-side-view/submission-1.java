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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        TreeNode nullNode = new TreeNode();

        q.offer(root);
        q.offer(nullNode);

        List<Integer> retList = new ArrayList<>();
        while(!q.isEmpty() && q.size() > 1) {
            TreeNode topel = q.poll();
            // get first node and add to list
            retList.add(topel.val);
            if(topel.right != null)
                q.offer(topel.right);
            if(topel.left != null)
                q.offer(topel.left);

            while(true) {
                topel = q.poll();
                if(topel == nullNode) {
                    q.offer(nullNode);
                    break;
                }
                if(topel.right != null)
                    q.offer(topel.right);
                if(topel.left != null)
                    q.offer(topel.left);
            }
        }
        return retList;
    }
}
