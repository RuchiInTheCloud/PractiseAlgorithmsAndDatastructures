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

            ListNode newHead = head.next;

            ListNode first, second;
            ListNode prev = null, next;
            ListNode current = head;
            while (current != null && current.next != null) {
                next = current.next.next;

                first = current.next;
                second = current;
                first.next = second;
                second.next = next;

                if (prev != null) {
                    prev.next = first;
                }
                prev = second;
                current = next;
            }

            return newHead;
        }
    }
}
