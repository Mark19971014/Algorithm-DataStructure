package LinkedList;

public class reverseLinkedListII_92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0,head);

        ListNode preleft = dummy;
        ListNode cur = head;
        //reach the node at position left
        for(int i = 0;i < left - 1; i++){
            preleft = preleft.next;
            cur = cur.next;
        }
        // now cur = Position left, preleft = 1 node before left
        // reverse the node from left to right
        ListNode prev = null;
        ListNode temp;
        for(int i = 0; i < right - left + 1; i++){
            temp = cur.next;
            cur.next = prev; // reverse the node
            prev = cur;
            cur = temp;
        }

        preleft.next.next = cur; // cur point to the first element after the reversal part, the next node of  preleft.next node need to point to the cur,because of reversal;
        preleft.next = prev; // update the preleft.next node as the last node in the reversal part,which prev pointer point to
        return dummy.next;
    }
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        reverseLinkedListII_92 solution = new reverseLinkedListII_92();

        // Create a test list 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original list:");
        solution.printList(head);

        // Reverse from position 2 to 4
        head = solution.reverseBetween(head, 2, 4);

        System.out.println("Reversed list (2 to 4):");
        solution.printList(head);
    }
}
