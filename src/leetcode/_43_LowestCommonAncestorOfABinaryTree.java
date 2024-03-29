package leetcode;

/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as
the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Example 2:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

Example 3:
Input: root = [1,2], p = 1, q = 2
Output: 1

Constraints:
The number of nodes in the tree is in the range [2, 105].
-10^9 <= Node.val <= 10^9
All Node.val are unique.
p != q
p and q will exist in the tree.
 */
public class _43_LowestCommonAncestorOfABinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root != null && (root == p && root == q)) {
                return root;
            } else if (root == null) {
                return null;
            }

            TreeNode node1 = lowestCommonAncestor(root.left, p, q);
            if (node1 != null && node1 != p && node1 != q) {
                return node1;
            }

            TreeNode node2 = lowestCommonAncestor(root.right, p, q);
            if (node2 != null && node2 != p && node2 != q) {
                return node2;
            }

            if ((node1 == p && node2 == q) || (node1 == q && node2 == p)) {
                return root;
            } else if (root == p || root == q) {
                return root;
            } else {
                return node1 == null ? node2 : node1;
            }
        }
    }
}
