package leetcode;

public class _33_FindTheWinnerOfTheCircularGame {
    class Solution {
        class ListNode {
            int val;
            ListNode next;
            public ListNode (int val) {
                this.val = val;
            }
        }
        public int findTheWinner(int n, int k) {
            ListNode prev = new ListNode(1);
            ListNode curr;
            ListNode first = prev;
            for (int i = 2; i <= n; i++) {
                curr = new ListNode(i);
                prev.next = curr;
                prev = curr;
            }
            prev.next = first;

            curr = first;
            while (curr.next != curr) {
                for (int i = 2; i <= k; i++) {
                    prev = curr;
                    curr = curr.next;
                }
                prev.next = curr.next;
                curr = curr.next;
            }
            return curr.val;
        }
    }
}
