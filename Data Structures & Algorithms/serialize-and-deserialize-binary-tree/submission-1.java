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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    void serialize(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("#,");
            return;
        } 
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // read till ,
        String[] tokens = data.split(",");
        int[] index = new int[1];
        return deserialize(tokens, index);
    }

    TreeNode deserialize(String[] data, int[] index) {
        String token = data[index[0]++];
        if(token.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(token));
        root.left = deserialize(data, index);
        root.right = deserialize(data, index);
        return root;
    }
}
