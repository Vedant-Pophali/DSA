package LinkedList.LeetCode;

// Hare and Tortoise Algorithm
// Floyd's Cycle Detection Algorithm
public class LinkedListCycle {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static class Solution {

        // Detects cycle in a linked list
        public static boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) return false;

            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    return true;
                }
            }

            return false;
        }

        public static void main(String[] args) {

            // Test Case 1: With a cycle (cycle at node 3)
            ListNode head1 = new ListNode(1);
            head1.next = new ListNode(2);
            head1.next.next = new ListNode(3);
            head1.next.next.next = new ListNode(4);
            head1.next.next.next.next = new ListNode(5);
            head1.next.next.next.next.next = head1.next.next; // cycle

            System.out.println("Test Case 1: Cycle expected");
            System.out.println("Linked List has cycle: " + hasCycle(head1));
            System.out.println();

            // Test Case 2: No cycle
            ListNode head2 = new ListNode(10);
            head2.next = new ListNode(20);
            head2.next.next = new ListNode(30);

            System.out.println("Test Case 2: No cycle expected");
            System.out.println("Linked List has cycle: " + hasCycle(head2));
            System.out.println();

            // Test Case 3: 2-node cycle
            ListNode head3 = new ListNode(100);
            head3.next = new ListNode(200);
            head3.next.next = head3; // cycle to head

            System.out.println("Test Case 3: Cycle expected");
            System.out.println("Linked List has cycle: " + hasCycle(head3));
        }
    }
}