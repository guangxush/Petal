package offer;

/**
 * @author: guangxush
 * @create: 2019/07/07
 * 题目描述:一个二维数组，每一行从左到右递增，每一列从上到下递增.输 入一个二维数组和一个整数，判断数组中是否含有整数。
 * 思路：从左下角开始找
 */
public class FindBinaryArrayElement {
    public static boolean find(int[][] array, int number) {
        if (array == null) {
            return false;
        }
        int column = array[0].length - 1;
        int row = 0;
        while (row < array.length && column >= 0) {
            if (array[row][column] == number) {
                return true;
            }
            if (array[row][column] > number) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
}
