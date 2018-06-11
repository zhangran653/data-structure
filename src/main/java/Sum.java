/**
 * @author zhangran
 * @since 2018-06-11
 **/
public class Sum {
    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    private static int sum(int[] arr, int l) {
        if (l == arr.length) {
            return 0;
        }
        return arr[l] + sum(arr, l + 1);

    }
}
