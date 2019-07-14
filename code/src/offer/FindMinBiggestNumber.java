package offer;

import java.util.Arrays;

/**
 * @author: guangxush
 * @create: 2019/07/14
 */
public class FindMinBiggestNumber {
    private static int findMaxNumber(int a[]) {
        int index = a.length - 1;
        for (int i = a.length - 1; i > 1; i--) {
            if (a[i] > a[i - 1]) {
                int temp = a[i];
                a[i] = a[i - 1];
                a[i - 1] = temp;
                index = i;
            }
        }
        return index;
    }

    private static void sortArray(int[] a, int begin) {
        int n = a.length;
        for (int j = 0; j < n - begin; j++) {
            for (int i = begin; i < n - 1 - j; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 2};
        int begin = findMaxNumber(a);
        sortArray(a, begin);
        System.out.println(Arrays.toString(a));
    }
}
