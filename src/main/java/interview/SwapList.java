package interview;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * <p>
 * 两两交换链表中的节点
 *
 * @author zhangran
 * @since 2018-11-17
 **/
public class SwapList {
    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * <p>
     * 示例:
     * <p>
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     * 说明:
     * <p>
     * 你的算法只能使用常数的额外空间。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     */


    public ListNode swapPairs(ListNode head) {
        // head为空或者head.next为空，直接返回
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head.next;

        ListNode next = null;
        ListNode pre = null;
        //
        while (head != null && head.next != null) {
            next = head.next;
            if (pre == null) {
                head.next = next.next;
                next.next = head;
                pre = head;
                head = head.next;
                continue;
            }
            pre.next = head.next;
            head.next = next.next;
            next.next = head;
            pre = head;
            head = head.next;

        }

        return node;
    }


    public static void main(String[] args) {
        ListNode n = new ListNode(2);
        n.next = new ListNode(5);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(6);
        n.next.next.next.next.next = new ListNode(2);
        n.next.next.next.next.next.next = new ListNode(2);
        new SwapList().swapPairs(n);
    }

}
