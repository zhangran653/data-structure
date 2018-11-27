package interview.stackarray;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/description/
 *
 * @author zhangran
 * @since 2018-11-27
 **/
public class PascalTriangle {

    /**
     * In Pascal's triangle, each number is the sum of the two numbers directly above it.
     * <p>
     * Example:
     * <p>
     * Input: 5
     * Output:
     * [
     * [1],
     * [1,1],
     * [1,2,1],
     * [1,3,3,1],
     * [1,4,6,4,1]
     * ]
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        if (numRows < 1) {
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            if (i == 1) {
                List<Integer> row = new ArrayList<>();
                row.add(1);
                lists.add(row);
            } else if (i == 2) {
                List<Integer> row = new ArrayList<>();
                row.add(1);
                row.add(1);
                lists.add(row);
            } else {
                List<Integer> lastRow = lists.get(i - 2);
                List<Integer> row = new ArrayList<>();
                row.add(1);
                for (int j = 1; j < i - 1; j++) {
                    row.add(lastRow.get(j - 1) + lastRow.get(j));
                }
                row.add(1);
                lists.add(row);
            }

        }
        return lists;

    }
}
