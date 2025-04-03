package LinkedList.LeetCode;

public class ReorderList {
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        //Finding Middle element
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //Split the list into 2 halves
        ListNode secondHalf = slow.next;
        slow.next = null;
        //Reverse the second half
        secondHalf = reverseList(secondHalf);
        //Merge first  half with second half
        ListNode current = head;
        while (secondHalf != null) {
            ListNode nextFirst = current.next;
            ListNode nextSecond = secondHalf.next;
            current.next = secondHalf;
            secondHalf.next = nextFirst;
            current = nextFirst;
            secondHalf = nextSecond;
        }
    }
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
    public static void main(String[] args) {
        // Test case 1: Regular list
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        reorderList(head1);
        printList(head1); // Expected: 1 -> 4 -> 2 -> 3

        // Test case 2: Odd number of elements
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reorderList(head2);
        printList(head2); // Expected: 1 -> 5 -> 2 -> 4 -> 3

        // Test case 3: Two elements
        ListNode head3 = new ListNode(1, new ListNode(2));
        reorderList(head3);
        printList(head3); // Expected: 1 -> 2

        // Test case 4: Single element
        ListNode head4 = new ListNode(1);
        reorderList(head4);
        printList(head4); // Expected: 1

        // Test case 5: Empty list
        ListNode head5 = null;
        reorderList(head5);
        printList(head5); // Expected: (no output)
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
