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

public class Codec {

    StringBuilder sb;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sb = new StringBuilder();
        serializeHelper(root);
        return sb.toString();
    }

    void serializeHelper(TreeNode root) {
        if(root == null) {
            sb.append("#").append(",");
            return;
        } 
        sb.append(root.val).append(",");
        serializeHelper(root.left);
        serializeHelper(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // read till ,
        Queue<String> tokens = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return deserializeHelper(tokens);
    }

    TreeNode deserializeHelper(Queue<String> data) {
        String token = data.poll();
        if(token.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(token));
        root.left = deserializeHelper(data);
        root.right = deserializeHelper(data);
        return root;
    }
}
