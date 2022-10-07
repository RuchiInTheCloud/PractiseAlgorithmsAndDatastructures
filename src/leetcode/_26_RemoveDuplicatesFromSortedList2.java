package leetcode;

/*
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

Example 1:
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]

Example 2:
Input: head = [1,1,1,2,3]
Output: [2,3]

Constraints:
The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
 */
public class _26_RemoveDuplicatesFromSortedList2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            while (true) {
                boolean hasDuplicate = false;
                while (head != null && head.next != null && head.val == head.next.val) {
                    head = head.next;
                    hasDuplicate = true;
                }

                if (hasDuplicate) {
                    head = head.next;
                }

                if (head != null && head.next != null && head.val != head.next.val) {
                    break;
                } else if (head == null || head.next == null) {
                    break;
                }
            }

            ListNode prev = null;
            ListNode current = head;
            while (current != null) {
                boolean hasDuplicate = false;
                while (current != null && current.next != null && current.val == current.next.val) {
                    current.next = current.next.next;
                    hasDuplicate = true;
                }

                if (hasDuplicate) {
                    prev.next = current.next;
                } else {
                    prev = current;
                }

                current = current.next;
            }

            return head;
        }
    }
}
