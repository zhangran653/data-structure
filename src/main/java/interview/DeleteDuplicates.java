package interview;

/**
 * @author zhangran
 * @since 2018-11-21
 **/
public class DeleteDuplicates {
    /**
     * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
     * <p>
     * Given a sorted linked list, delete all duplicates such that each element appear only once.
     * <p>
     * Example 1:
     * <p>
     * Input: 1->1->2
     * Output: 1->2
     * Example 2:
     * <p>
     * Input: 1->1->2->3->3
     * Output: 1->2->3
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while (cur != null && cur.next != null) {
           if(cur.val==cur.next.val){
               cur.next = cur.next.next;
           }else {
               cur = cur.next;
           }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(1);
        n.next.next = new ListNode(2);
//        n.next.next.next = new ListNode(4);
//        n.next.next.next.next = new ListNode(6);
//        n.next.next.next.next.next = new ListNode(2);
//        n.next.next.next.next.next.next = new ListNode(2);
        new DeleteDuplicates().deleteDuplicates(n);
    }
}
