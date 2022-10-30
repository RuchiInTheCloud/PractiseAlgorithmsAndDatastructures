package leetcode;

/*
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]

Constraints:
1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.
*/
public class _36_ConstructBinaryTreeFromPreOrderAndInorderTraversal {
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        }

        private TreeNode buildTree(int[] preorder, int[] inorder, int pL, int pR, int iL, int iR) {
            if (pL > pR || iL > iR) {
                return null;
            }

            TreeNode root = new TreeNode(preorder[pL]);
            int iM = searchIndex(inorder, preorder[pL]);
            root.left = buildTree(preorder, inorder, pL + 1, pL + (iM - iL), iL, iM - 1);
            root.right = buildTree(preorder, inorder, pL + (iM - iL) + 1, pR, iM + 1, iR);
            return root;
        }

        private int searchIndex(int[] inorder, int val) {
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == val) {
                    return i;
                }
            }
            return -1;
        }
    }
}
