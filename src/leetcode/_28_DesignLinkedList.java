package leetcode;

/*
Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:
MyLinkedList() Initializes the MyLinkedList object.
int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
void addAtTail(int val) Append a node of value val as the last element of the linked list.
void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.

Example 1:
Input
["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
[[], [1], [3], [1, 2], [1], [1], [1]]
Output
[null, null, null, null, 2, null, 3]

Explanation
MyLinkedList myLinkedList = new MyLinkedList();
myLinkedList.addAtHead(1);
myLinkedList.addAtTail(3);
myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
myLinkedList.get(1);              // return 2
myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
myLinkedList.get(1);              // return 3

Constraints:
0 <= index, val <= 1000
Please do not use the built-in LinkedList library.
At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and deleteAtIndex.
 */
public class _28_DesignLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    class MyLinkedList {
        class ListNode {
            int val;
            ListNode next;

            ListNode(int val) {
                this.val = val;
            }
        }

        ListNode head = null;

        public MyLinkedList() {

        }

        public int get(int index) {
            ListNode current = head;
            int i = 0;
            while (current != null && i <= index) {
                if (i == index) {
                    break;
                }
                i++;
                current = current.next;
            }

            if (current != null) {
                return current.val;
            } else {
                return -1;
            }
        }

        public void addAtHead(int val) {
            ListNode node = new ListNode(val);
            node.next = head;
            head = node;
        }

        public void addAtTail(int val) {
            ListNode node = new ListNode(val);

            if (head == null) {
                head = node;
                return;
            }

            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }

            current.next = node;
        }

        public void addAtIndex(int index, int val) {
            ListNode node = new ListNode(val);
            if (index == 0) {
                node.next = head;
                head = node;
                return;
            }

            ListNode current = head;
            int i = 0;
            while (current != null && i <= index - 1) {
                if (i == index - 1) {
                    break;
                }
                i++;
                current = current.next;
            }

            if (current != null) {
                node.next = current.next;
                current.next = node;
            }
        }

        public void deleteAtIndex(int index) {
            if (head == null) {
                return;
            }

            if (index == 0) {
                head = head.next;
                return;
            }

            ListNode current = head;
            int i = 0;
            while (current != null && i <= index - 1) {
                if (i == index - 1) {
                    break;
                }
                i++;
                current = current.next;
            }

            if (current != null && current.next != null) {
                current.next = current.next.next;
            }
        }
    }
}
