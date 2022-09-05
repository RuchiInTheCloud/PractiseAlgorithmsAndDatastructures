package leetcode;

public class _33_FindTheWinnerOfTheCircularGame {
    static class LinkedNode {
        int val;

        LinkedNode next;
        LinkedNode prev;

        LinkedNode(int val) {
            this.val = val;
        }
    }

    static public int findTheWinner(int n, int k) {
        LinkedNode head = new LinkedNode(1);
        LinkedNode prev = head;
        LinkedNode next = head;

        if (n > 1) {
            for (int i = 2; i <= n; i++) {
                next = new LinkedNode(i);
                prev.next = next;
                next.prev = prev;
                prev = next;
            }
        }
        head.prev = next;
        next.next = head;

        LinkedNode current = head;
        while (current.next != current) {
            for (int i = 2; i <= k; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            current = current.next;
        }
        return current.val;
    }

    public static void main(String[] args) {
        findTheWinner(5, 2);
    }
}
