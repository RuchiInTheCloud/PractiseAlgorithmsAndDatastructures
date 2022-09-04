package leetcode;

public class _31_ReorderList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    class Pair {
        ListNode head;
        ListNode tail;

        Pair(ListNode head, ListNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    class Solution {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) {
                return;
            }

            int length = length(head);
            Pair pair = reconstructList(head, length);
        }

        private Pair reconstructList(ListNode head, int length) {
            if (length == 1) {
                ListNode next = head.next;
                head.next = null;
                return new Pair(head, next);
            } else if (length == 2) {
                ListNode next = head.next.next;
                head.next.next = null;
                return new Pair(head, next);
            }
            Pair pair = reconstructList(head.next, length - 2);
            head.next = pair.tail;
            pair.tail = pair.tail.next;

            head.next.next = pair.head;
            pair.head = head;
            return pair;
        }

        private int length(ListNode head) {
            int length = 0;
            while (head != null) {
                head = head.next;
                length++;
            }
            return length;
        }
    }
}
