public class Prob82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode();
        ListNode tmp = dummyHead;
        ListNode ptr = head;
        while (ptr != null) {
            if (ptr.next != null) {
                if (ptr.next.val != ptr.val) {
                    tmp.next = ptr;
                    tmp = tmp.next;
                } else {
                    // ptr指向了一个重复的数，要跳过
                    while (ptr.next != null && ptr.next.val == ptr.val) {
                        ptr = ptr.next;
                    }
                }
            } else {
                tmp.next = ptr;
                tmp = tmp.next;
            }
            ptr = ptr.next;
        }

        return dummyHead.next;
    }
}
