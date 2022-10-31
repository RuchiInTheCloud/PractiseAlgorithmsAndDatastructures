package leetcode;

/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored
in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or
another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/
deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this
 string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need
 to follow this format, so please be creative and come up with different approaches yourself.

Example 1:
Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]

Example 2:
Input: root = []
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000
 */
public class _45_SerializeAndDeserializeBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        private void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("X,");
                return;
            }
            sb.append(root.val + ",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        class Index {
            int index = 0;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Index index = new Index();
            return deserialize(data, index);
        }

        private TreeNode deserialize(String data, Index index) {
            Integer val = getValue(data, index);
            if (val == null) {
                return null;
            }

            TreeNode root = new TreeNode(val);
            root.left = deserialize(data, index);
            root.right = deserialize(data, index);
            return root;
        }

        private Integer getValue(String data, Index index) {
            String substring = data.substring(index.index, data.indexOf(',', index.index));
            if ("X".equals(substring)) {
                index.index += 2;
                return null;
            } else {
                index.index += (substring.length() + 1);
                return Integer.parseInt(substring);
            }
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec ser = new Codec();
    // Codec deser = new Codec();
    // TreeNode ans = deser.deserialize(ser.serialize(root));
}
