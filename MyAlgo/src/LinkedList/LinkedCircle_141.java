package LinkedList;

import java.util.List;

public class LinkedCircle_141 {

    public boolean hasCycle(ListNode head){
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Create nodes and immediately link them
        ListNode fourth = new ListNode(-4, null); // Last node initially points to null
        ListNode third = new ListNode(0, fourth); // Third node points to fourth
        ListNode second = new ListNode(2, third); // Second node points to third
        ListNode head = new ListNode(3, second);  // Head points to second

        // Create a cycle by linking the last node back to the second
        fourth.next = second;

        // Test for cycle
        LinkedCircle_141 lc = new LinkedCircle_141();
        boolean hasCycle = lc.hasCycle(head);
        System.out.println(hasCycle);



    }
}
