package leetcode;

/*
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values
of the nodes in the tree.

Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3

Constraints:
The number of nodes in the tree is n.
1 <= k <= n <= 10^4
0 <= Node.val <= 10^4


Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth
smallest frequently, how would you optimize?
 */
public class _41_kThSmallestElementInABST {
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
        class Result {
            int index = 0;
            int val = -1;
        }

        public int kthSmallest(TreeNode root, int k) {
            Result res = new Result();
            kthSmallest(root, k, res);
            return res.val;
        }

        public void kthSmallest(TreeNode root, int k, Result res) {
            if (root == null || res.index == k) {
                return;
            }

            kthSmallest(root.left, k, res);

            if (res.index < k) {
                res.index += 1;
                if (res.index == k) {
                    res.val = root.val;
                    return;
                }

                kthSmallest(root.right, k, res);
            }
        }
    }
}
