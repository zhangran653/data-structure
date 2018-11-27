package interview.stackarray;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/discuss/194964/java-O(K)-space-beats-91.86
 *
 * @author zhangran
 * @since 2018-11-27
 **/
public class PascalTriangle2 {

    /**
     * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
     * <p>
     * Note that the row index starts from 0.
     * Could you optimize your algorithm to use only O(k) extra space?
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex < 0) {
            return list;
        }
        list.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = list.size() - 1; j >= 1; j--) {
                list.set(j, list.get(j - 1) + list.get(j));
            }
            list.add(1);
        }

        return list;
    }

    public static void main(String[] args) {
        new PascalTriangle2().getRow(3);
    }
}
