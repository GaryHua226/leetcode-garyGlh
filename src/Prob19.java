import leetcodeUtil.ListNode;

public class Prob19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = head;

        ListNode BeforeToBeRemoved = dummyHead;
        ListNode p = head;
        for (int i = 0; i <n; i++)
            p = p.next;

        while (p != null) {
            p = p.next;
            BeforeToBeRemoved = BeforeToBeRemoved.next;
        }

        BeforeToBeRemoved.next = BeforeToBeRemoved.next.next;
        return head;
    }
}

