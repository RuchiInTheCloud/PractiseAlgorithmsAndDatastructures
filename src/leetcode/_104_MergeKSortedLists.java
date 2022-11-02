package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2:
Input: lists = []
Output: []

Example 3:
Input: lists = [[]]
Output: []

Constraints:
k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 10^4.

k lists of size n: O(nlogk)
 */
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
