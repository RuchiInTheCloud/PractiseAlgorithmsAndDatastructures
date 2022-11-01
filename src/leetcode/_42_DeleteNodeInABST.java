package leetcode;

public class _42_DeleteNodeInABST {
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
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }

            if (root.val == key) {
                return helper(root);
            }

            TreeNode curr = root;
            while (curr != null) {
                if (curr.val > key) {
                    if (curr.left != null && curr.left.val == key) {
                        curr.left = helper(curr.left);
                    } else {
                        curr = curr.left;
                    }
                } else {
                    if (curr.right != null && curr.right.val == key) {
                        curr.right = helper(curr.right);
                    } else {
                        curr = curr.right;
                    }
                }
            }
            return root;
        }

        private TreeNode helper(TreeNode root) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode rightChild = root.right;
                TreeNode lastLeftChild = findLastRight(root.left);
                lastLeftChild.right = rightChild;
                return root.left;
            }
        }

        private TreeNode findLastRight(TreeNode root) {
            while (root.right != null) {
                root = root.right;
            }
            return root;
        }
    }
}
