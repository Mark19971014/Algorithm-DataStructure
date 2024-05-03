package LinkedList;

public class mergeTwoList_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p = list1;
        ListNode q = list2;
        ListNode dummyHead = new ListNode(-1);
        ListNode dummy = dummyHead;
        while (p != null && q != null){
            if (p.val <= q.val){
                dummy.next = p;
                p = p.next;
            }else {
                dummy.next = q;
                q = q.next;
            }

            dummy = dummy.next;
        }

        if(p != null){
            dummy.next = p;
        } else if(q != null){
            dummy.next = q;

        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode list1_1 = new ListNode(1);
        ListNode list1_2 = new ListNode(2);
        ListNode list1_3 = new ListNode(4);


        ListNode list2_1 = new ListNode(1);
        ListNode list2_2 = new ListNode(3);
        ListNode list2_3 = new ListNode(4);

        mergeTwoList_21 test = new mergeTwoList_21();
        list1_1.next = list1_2;
        list1_2.next = list1_3;
        list2_1.next = list2_2;
        list2_2.next = list2_3;
        ListNode head = test.mergeTwoLists(list1_1,list2_1);

        while (head != null){

            System.out.println(head.val);
            head = head.next;
        }

    }
}
