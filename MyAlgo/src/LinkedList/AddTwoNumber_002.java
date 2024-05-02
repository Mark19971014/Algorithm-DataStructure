package LinkedList;

public class AddTwoNumber_002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        ListNode p1 = l1, p2 = l2;
        int sum = 0;
        int carry = 0;
        while(p1 != null || p2 != null){
            int x = (p1 == null) ? 0 : p1.val;
            int y = (p2 == null) ? 0 : p2.val;
            sum = x + y + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }

        if(carry > 0){
            current.next = new ListNode(carry);
        }

        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode head1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);

        ListNode head2 = new ListNode(8);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9);

        head1.next = node2;
        node2.next = node3;

        head2.next = node4;
        node4.next = node5;

        AddTwoNumber_002 test = new AddTwoNumber_002();
        ListNode result = test.addTwoNumbers(head1, head2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
     }
}
