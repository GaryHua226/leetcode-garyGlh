import leetcodeUtil.ListNode;

public class Prob24 {
    public ListNode swapPairs(ListNode head) {
        return swapPairs_r(head);
    }

    private ListNode swapPairs_r(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = head.next;
        head.next = head.next.next;
        res.next = head;
        res.next.next = swapPairs(res.next.next);
        return res;
    }
}
