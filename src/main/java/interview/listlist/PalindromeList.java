package interview.listlist;

/**
 * https://leetcode.com/problems/palindrome-linked-list/description/
 *
 * @author zhangran
 * @since 2018-11-23
 **/
public class PalindromeList {


    /**
     * Given a singly linked list, determine if it is a palindrome.
     * <p>
     * Example 1:
     * <p>
     * Input: 1->2
     * Output: false
     * Example 2:
     * <p>
     * Input: 1->2->2->1
     * Output: true
     * Follow up:
     * Could you do it in O(n) time and O(1) space?
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        //1.找到中间节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow;
        //2.翻转中间节点
        ListNode pre = null;
        ListNode next = null;
        while (middle != null) {
            next = middle.next;
            middle.next = pre;
            pre = middle;
            middle = next;
        }
        //3. 比较
        while (pre != null) {
            if (pre.val != head.val) {
                return false;
            } else {
                pre = pre.next;
                head = head.next;
            }
        }
        return true;
    }
}
