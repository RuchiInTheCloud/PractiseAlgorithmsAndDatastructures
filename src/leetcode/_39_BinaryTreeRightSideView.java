package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _39_BinaryTreeRightSideView {
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
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            List<TreeNode> level = new LinkedList<>(List.of(root));
            TreeNode node = null;
            while (!level.isEmpty()) {
                int length = level.size() - 1;
                while (length >= 0) {
                    node = level.remove(0);
                    length -= 1;
                    if (node.left != null) {
                        level.add(node.left);
                    }
                    if (node.right != null) {
                        level.add(node.right);
                    }
                }
                result.add(node.val);
            }
            return result;
        }
    }
}
