package LinkedList;

public class reverseLinkedList_206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp;
        while(cur != null){
            // store the next node of the current node
            temp = cur.next;
            // reverse the list
            cur.next = prev;
            // shift the pointer
            prev = cur;
            cur = temp;

        }

        return prev;
    }

    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // Print the original linked list
        System.out.println("Original linked list:");
        printList(head);

        // Reverse the linked list
        reverseLinkedList_206 reverseListObj = new reverseLinkedList_206();
        head = reverseListObj.reverseList(head);

        // Print the reversed linked list
        System.out.println("Reversed linked list:");
        printList(head);
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }
}
