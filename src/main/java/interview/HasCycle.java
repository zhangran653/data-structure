package interview;

/**
 * @author zhangran
 * @since 2018-11-21
 **/
public class HasCycle {

    /**
     * https://leetcode.com/problems/linked-list-cycle/description/
     * <p>
     * Given a linked list, determine if it has a cycle in it.
     * <p>
     * Follow up:
     * Can you solve it without using extra space?
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast.equals(slow)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);

        new HasCycle().hasCycle(n);
    }

}
