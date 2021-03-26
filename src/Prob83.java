public class Prob83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode ptr = head;
        ListNode next = ptr.next;
        while (next != null) {
            if (ptr.val != next.val) {
                ptr.next = next;
                ptr = ptr.next;
            }
            next = next.next;
        }
        ptr.next = null;
        return head;
    }
}
