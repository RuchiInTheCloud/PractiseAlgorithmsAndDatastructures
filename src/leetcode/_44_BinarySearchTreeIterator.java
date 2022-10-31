package leetcode;

import java.util.Stack;

public class _44_BinarySearchTreeIterator {
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

    class BSTIterator {
        Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            TreeNode curr = root;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
        }

        public int next() {
            TreeNode res = stack.pop();
            TreeNode curr = res.right;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            return res.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    /**
     * Your BSTIterator object will be instantiated and called as such:
     * BSTIterator obj = new BSTIterator(root);
     * int param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */
}
