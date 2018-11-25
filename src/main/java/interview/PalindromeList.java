package interview;

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

        return false;
    }
}
