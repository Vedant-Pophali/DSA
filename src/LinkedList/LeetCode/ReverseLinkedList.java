package LinkedList.LeetCode;

public class ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private ListNode newHead;

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode last = rev(head);
        last.next = null;
        head = newHead;
        return head;
    }

    public ListNode rev(ListNode node) {
        if (node.next == null) { // checks if given node is the last node
            newHead = node;
            return node;
        } else {
            ListNode last = rev(node.next);
            last.next = node;
            return node;
        }
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();

        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        // Reversing the linked list
        head = list.reverseList(head);

        System.out.println("Reversed List:");
        printList(head);
    }
}
