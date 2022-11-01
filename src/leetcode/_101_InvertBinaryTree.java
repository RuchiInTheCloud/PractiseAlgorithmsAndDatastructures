package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
Given the root of a binary tree, invert the tree, and return its root.

Example 1:
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]

Example 2:
Input: root = [2,1,3]
Output: [2,3,1]

Example 3:
Input: root = []
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */
public class _101_InvertBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root != null) {
                Queue<TreeNode> queue = new LinkedList<TreeNode>();
                queue.add(root);
                while (!queue.isEmpty()) {
                    int len = queue.size();
                    for (int i = 0; i < len; i++) {
                        TreeNode node = queue.remove();
                        if (node.left != null) {
                            queue.add(node.left);
                        }
                        if (node.right != null) {
                            queue.add(node.right);
                        }
                        TreeNode tmp = node.left;
                        node.left = node.right;
                        node.right = tmp;
                    }
                }
            }
            return root;
        }
    }
}
