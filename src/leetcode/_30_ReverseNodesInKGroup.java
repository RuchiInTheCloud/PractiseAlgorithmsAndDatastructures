package leetcode;

/*
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
You may not alter the values in the list's nodes, only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Example 2:
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]

Constraints:
The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000

Follow-up: Can you solve the problem in O(1) extra memory space?
 */
public class _30_ReverseNodesInKGroup {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (k == 1) {
                return head;
            }

            ListNode newHead = getNode(head, k);
            ListNode current = head;

            ListNode initial;
            ListNode first;
            ListNode second;
            ListNode prev = null;
            ListNode next;
            ListNode temp;
            while (current != null) {
                int i = 0;

                initial = current;
                while (current != null && current.next != null && ((k % 2 == 1 && i < k - 1) || (k % 2 == 0
                        && i < k))) {
                    first = current;
                    second = current.next;
                    next = current.next.next;

                    temp = first;
                    first = second;
                    second = temp;

                    first.next = second;
                    second.next = null;

                    if (prev != null) {
                        second.next = prev;
                    }
                    prev = first;

                    current = next;
                    i += 2;
                }
                if (i > 0 && i < k && current != null) {
                    next = current.next;
                    current.next = prev;
                    current = next;
                }

                prev = null;

                if (current != null) {
                    initial.next = getNode(current, k);
                    if (initial.next == current) {
                        break;
                    }
                }
            }
            return newHead;
        }

        ListNode getNode(ListNode head, int index) {
            ListNode current = head;
            int i = 1;
            while (i < index && current.next != null) {
                current = current.next;
                i += 1;
            }
            return i < index ? head : current;
        }
    }
}
