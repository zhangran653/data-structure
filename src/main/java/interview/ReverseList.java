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

    /**
     * 假设整个链表有N个节点，要将整个链表反转，可以先将除第一个元素外的剩下N-1个元素先反转，再把第一个元素插入到剩下链表的末尾。
     * 再将问题往下细分，直到遇到空节点。要注意到异常情况（链表为空或只有一个或两个节点）
     *
     * @param head
     * @return
     */
    public ListNode recursionReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode second = head.next;
        ListNode rest = recursionReverseList(second);
        second.next = head;
        head.next = null;
        return rest;
    }

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
//        n.next.next.next.next = new ListNode(6);
//        n.next.next.next.next.next = new ListNode(2);
//        n.next.next.next.next.next.next = new ListNode(2);
        new ReverseList().recursionReverseList(n);
    }
}
