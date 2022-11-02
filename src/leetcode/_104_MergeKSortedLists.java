package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _104_MergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }

            Queue<ListNode> queue = new LinkedList<ListNode>(Arrays.asList(lists));

            while (queue.size() > 1) {
                ListNode list1 = queue.remove();
                ListNode list2 = queue.isEmpty() ? null : queue.remove();
                queue.add(mergeTwoLists(list1, list2));
            }

            return queue.remove();
        }

        private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode();
            ListNode prev = dummy;
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    prev.next = list1;
                    list1 = list1.next;
                } else {
                    prev.next = list2;
                    list2 = list2.next;
                }
                prev = prev.next;
            }
            if (list2 != null) {
                prev.next = list2;
            } else if (list1 != null) {
                prev.next = list1;
            }
            return dummy.next;
        }
    }
}
