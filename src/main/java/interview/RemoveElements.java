package interview;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 *
 * @author zhangran
 * @since 2018-11-22
 **/
public class RemoveElements {
    /**
     * Remove all elements from a linked list of integers that have value val.
     * <p>
     * Example:
     * <p>
     * Input:  1->2->6->3->4->5->6, val = 6
     * Output: 1->2->3->4->5
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            if (cur.val == val) {
                if (pre == null) {
                    head = head.next;
                    cur = head;
                } else {
                    ListNode tempNext = cur.next;
                    pre.next = cur.next;
                    cur.next = null;
                    cur = tempNext;
                }
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    public ListNode removeElementsRecursion(ListNode head, int val) {
        if (head == null || (head.next == null && head.val == val)) {
            return null;
        }
        ListNode next = removeElements(head.next, val);
        head.next = next;
        return head;
    }
}
