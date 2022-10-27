package leetcode;

public class _31_ReorderList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    class Solution {
        public void reorderList(ListNode head) {
            ListNode p1 = head;
            ListNode p2 = head;
            ListNode prev = null;
            while (p2 != null && p2.next != null) {
                prev = p1;
                p1 = p1.next;
                p2 = p2.next.next;
            }
            if (p2 != null) {
                prev = p1;
                p1 = p1.next;
            }
            prev.next = null;

            ListNode curr = p1;
            ListNode next = null;
            prev = null;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            ListNode curr1 = head;
            ListNode curr2 = prev;
            ListNode next1 = null;
            ListNode next2 = null;
            while (curr2 != null) {
                next1 = curr1.next;
                next2 = curr2.next;

                curr1.next = curr2;
                curr2.next = next1;

                curr1 = next1;
                curr2 = next2;
            }
        }
    }
}
