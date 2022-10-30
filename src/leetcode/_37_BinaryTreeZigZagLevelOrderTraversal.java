package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to
right, then right to left for the next level and alternate between).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
 */
public class _37_BinaryTreeZigZagLevelOrderTraversal {
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            List<Integer> resultLevel;
            List<TreeNode> level = List.of(root);
            List<TreeNode> newLevel;

            boolean leftToRight = true;
            int index, start, end, increment;

            while (!level.isEmpty()) {
                newLevel = new ArrayList<>();
                resultLevel = new ArrayList<>();

                start = leftToRight ? 0 : level.size() - 1;
                end = leftToRight ? level.size() : -1;
                increment = leftToRight ? 1 : -1;
                for (index = start; index != end; index += increment) {
                    resultLevel.add(level.get(index).val);
                }
                result.add(resultLevel);

                for (TreeNode node : level) {
                    if (node.left != null) {
                        newLevel.add(node.left);
                    }
                    if (node.right != null) {
                        newLevel.add(node.right);
                    }
                }
                level = newLevel;
                leftToRight = !leftToRight;
            }
            return result;
        }
    }
}
