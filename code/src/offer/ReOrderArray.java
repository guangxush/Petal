package offer;

/**
 * @author: guangxush
 * @create: 2019/08/18
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int i = 0, j = 1;
        while (i < array.length) {
            //i从左向右遍历，找到第一个偶数
            while (i < array.length && array[i] % 2 != 0) {
                i++;
            }
            j = i + 1;
            //j从i+1开始向后找，直到找到第一个奇数
            while (j < array.length && array[j] % 2 == 0) {
                j++;
            }
            if (j < array.length) {
                int temp = array[j];
                for (int j2 = j - 1; j2 >= i; j2--) {
                    array[j2 + 1] = array[j2];
                }
                array[i] = temp;
                i++;
            } else {
                break;
            }
        }
    }
}
/**
 * 1.要想保证原有次序，则只能顺次移动或相邻交换。
 * 2.i从左向右遍历，找到第一个偶数。
 * 3.j从i+1开始向后找，直到找到第一个奇数。
 * 4.将[i,...,j-1]的元素整体后移一位，最后将找到的奇数放入i位置，然后i++。
 * 5.終止條件：j向後遍歷查找失敗。
 */
