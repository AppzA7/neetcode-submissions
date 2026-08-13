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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList();
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode nullNode = new TreeNode();
        queue.offer(root);
        queue.offer(nullNode);

        List<List<Integer>> returnList = new ArrayList<>();
        List<Integer> subList = new ArrayList();
        while(!queue.isEmpty()) {
            TreeNode topNode = queue.poll();
            if(topNode == nullNode) {
                returnList.add(subList);
                if(queue.isEmpty()) break;
                subList = new ArrayList<>();
                queue.offer(nullNode);
                continue;
            }
            subList.add(topNode.val);
            if(topNode.left != null)
                queue.offer(topNode.left);
            if(topNode.right != null)
                queue.offer(topNode.right);
        }
        return returnList;
    }
}
