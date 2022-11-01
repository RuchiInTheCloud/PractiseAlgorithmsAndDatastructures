package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _96_BinaryTreePostOrderTraversal {
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
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            TreeNode curr = root;
            TreeNode parent = null;
            Stack<TreeNode> stack = new Stack<>();

            TreeNode prev = null;
            while (curr != null || !stack.isEmpty()) {
                if (curr != null) {
                    stack.push(curr);
                    prev = curr;
                    curr = curr.left;
                } else {
                    curr = stack.peek();
                    if (curr.right == null || curr.right == prev) {
                        prev = stack.pop();
                        result.add(prev.val);
                        curr = null;
                    } else {
                        prev = curr;
                        curr = curr.right;
                    }
                }
            }
            return result;
        }
    }
}
