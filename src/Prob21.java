import java.util.List;

public class Prob21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode d1 = new ListNode();
        ListNode d2 = new ListNode();
        ListNode res = new ListNode();
        d1.next = l1;
        d2.next = l2;
        res = d1;

        while (d1.next != null && d2.next != null) {
            if (d1.next.val <= d2.next.val) {
                d1 = d1.next;
            } else {
                ListNode temp = d1.next;
                d1.next = d2.next;
                d2.next = d2.next.next;
                d1.next.next = temp;
                d1 = d1.next;
            }
        }

        if (d1.next == null) {
            d1.next = d2.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode ll1 = new ListNode(1);
        ListNode ll2 = new ListNode(3);
        ListNode ll3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;

        ll1.next = ll2;
        ll2.next = ll3;

        Prob21 prob21 = new Prob21();
        prob21.mergeTwoLists(l1, ll1);
    }
}
