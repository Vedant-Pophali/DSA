package LinkedList.LeetCode;

public class MiddleOfTheLinkedList {
    public static ListNode middleNode(ListNode head) {
        ListNode fast=head,slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

        }
        return slow;
    }
    public static void main(String[] args) {
        // Test case 1: Odd number of elements
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(middleNode(head1).val); // Expected: 3

        // Test case 2: Even number of elements
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        System.out.println(middleNode(head2).val); // Expected: 4

        // Test case 3: Two elements
        ListNode head3 = new ListNode(1, new ListNode(2));
        System.out.println(middleNode(head3).val); // Expected: 2

        // Test case 4: Single element
        ListNode head4 = new ListNode(1);
        System.out.println(middleNode(head4).val); // Expected: 1

        // Test case 5: Empty list
        ListNode head5 = null;
        System.out.println(middleNode(head5)); // Expected: null
    }
}