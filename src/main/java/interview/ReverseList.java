package interview;

/**
 * @author zhangran
 * @since 2018-11-18
 **/
public class ReverseList {
    /**
     * Reverse a singly linked list.
     * <p>
     * Example:
     * <p>
     * Input: 1->2->3->4->5->NULL
     * Output: 5->4->3->2->1->NULL
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
//        n.next.next.next.next = new ListNode(6);
//        n.next.next.next.next.next = new ListNode(2);
//        n.next.next.next.next.next.next = new ListNode(2);
        new ReverseList().reverseList(n);
    }
}
