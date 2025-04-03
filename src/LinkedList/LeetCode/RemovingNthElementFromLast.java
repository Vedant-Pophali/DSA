package LinkedList.LeetCode;

public class RemovingNthElementFromLast {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < n + 1; i++) {
            if (fast == null) {
                head = head.next;
                return head;
            }
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    public static void main(String[] args) {
        // Test case 1: Remove 2nd element from end (regular case)
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        head1 = removeNthFromEnd(head1, 2);
        printList(head1); // Expected: 1 -> 2 -> 3 -> 5

        // Test case 2: Remove last element
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3)));
        head2 = removeNthFromEnd(head2, 1);
        printList(head2); // Expected: 1 -> 2

        // Test case 3: Remove first element
        ListNode head3 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        head3 = removeNthFromEnd(head3, 4);
        printList(head3); // Expected: 2 -> 3 -> 4

        // Test case 4: Single element list (removal results in empty list)
        ListNode head4 = new ListNode(1);
        head4 = removeNthFromEnd(head4, 1);
        printList(head4); // Expected: (no output)

        // Test case 5: Two-element list, removing 1st element
        ListNode head5 = new ListNode(1, new ListNode(2));
        head5 = removeNthFromEnd(head5, 2);
        printList(head5); // Expected: 2
    }


    // Helper function to print the linked list
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}