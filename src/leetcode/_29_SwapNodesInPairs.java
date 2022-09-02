package leetcode;

/*
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

Example 1:
Input: head = [1,2,3,4]
Output: [2,1,4,3]

Example 2:
Input: head = []
Output: []

Example 3:
Input: head = [1]
Output: [1]

Constraints:
The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
 */
public class _29_SwapNodesInPairs {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode prev = null;
            ListNode temp;
            ListNode p1 = head;
            ListNode p2 = head.next;
            ListNode p3;

            head = p2;

            while (p2 != null) {
                p3 = p2.next;

                temp = p2;
                p2 = p1;
                p1 = temp;
                p1.next = p2;
                p2.next = p3;

                if (prev != null) {
                    prev.next = p1;
                }

                if (p3 != null) {
                    prev = p2;
                    p1 = p3;
                    p2 = p3.next;
                } else {
                    p1 = p2 = p3 = prev = temp = null;
                }
            }
            return head;
        }
    }
}
