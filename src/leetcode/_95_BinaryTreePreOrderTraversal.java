package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _95_BinaryTreePreOrderTraversal {
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
        public List<Integer> preorderTraversal(TreeNode root) {
            TreeNode curr = root;
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> result = new ArrayList<>();
            while (curr != null || !stack.isEmpty()) {
                if (curr != null) {
                    result.add(curr.val);
                    if (curr.right != null) {
                        stack.push(curr.right);
                    }
                    curr = curr.left;
                } else {
                    curr = stack.pop();
                }
            }
            return result;
        }
    }
}
