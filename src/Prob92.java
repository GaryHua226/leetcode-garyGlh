public class Prob92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode h = new ListNode();
        h.next = head;
        ListNode t = new ListNode();
        t = head;
        for (int i = 0; i < left - 1; i++)
            t = t.next;
        ListNode start = t.next;
        ListNode next = start.next;
        ListNode next_next = next.next;
        ListNode t1 = next;
        for (int i = left; i < right; i++) {
            next.next = start;
            if ( i == right - 1) {
                t.next = next;
                t1.next = next_next;
                break;
            }
            start = next;
            next = next_next;
            next_next = next_next.next;
        }
        return h.next;
    }
}
