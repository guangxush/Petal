package offer;

import java.util.ArrayList;

/**
 * @author: guangxush
 * @create: 2019/08/27
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbersOne(int[] array, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || k <= 0 || k > array.length) {
            return list;
        }
        int start = 0;
        int end = array.length - 1;
        int index = Partion(array, start, end);
        while (index != (k - 1)) {
            if (index > (k - 1)) {
                index = Partion(array, 0, index - 1);
            } else {
                index = Partion(array, index + 1, k - 1 - index);
            }
        }
        for (int i = 0; i < k; i++) {
            list.add(array[i]);
        }
        return list;
    }

    private int Partion(int[] array, int start, int end) {
        int i = start;
        int j = end;
        int pivot = array[i];
        while (i < j) {
            while (i < j && pivot < array[j]) {
                j--;
            }
            if (i < j) {
                array[i] = array[j];
                array[j] = pivot;
                i++;
            }
            while (i < j && pivot > array[i]) {
                i++;
            }
            if (i < j) {
                array[j] = array[i];
                array[i] = pivot;
                j--;
            }
        }
        return i;
    }


    public ArrayList<Integer> GetLeastNumbersTwo(int[] array, int k) {
        ArrayList<Integer> leastNumbers = new ArrayList<>();
        if (array == null || k <= 0 || k > array.length) {
            return leastNumbers;
        }
        //初始化为最大堆
        for (int i = k / 2-1; i >= 0; i--) {
            adjustHeap(array, i, k);
        }
        //从第k个元素开始分别与最大堆的最大值做比较，如果比最大值小，则替换并调整堆,最终堆里的就是最小的K个数
        for (int i = k; i < array.length; i++) {
            if (array[i] < array[0]) {
                int temp = array[0];
                array[0] = array[i];
                array[i] = temp;
                adjustHeap(array, 0, k);
            }
        }
        for (int i = 0; i < k; i++) {
            leastNumbers.add(array[i]);
        }
        return leastNumbers;
    }

    private void adjustHeap(int[] array, int parentIndex, int end) {
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < end) {
            if (childIndex + 1 < end && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }
            if (array[childIndex] < temp) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * parentIndex + 1;
        }
        array[parentIndex] = temp;
    }

    public static void main(String[] args) {
        int[] array = {7, 9, 3, 6, 1, 11, 2, 4, 5, 8, 10};
        int[] array2 = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        ArrayList<Integer> result = new ArrayList<>();
//        result = getLeastNumbers.GetLeastNumbersOne(array, k);
//        System.out.println(result.toString());
        result = getLeastNumbers.GetLeastNumbersTwo(array2, k);
        System.out.println(result.toString());
    }
}

/**
 * 优缺点:
 * 思路1
 * 优点：节省空降，时间复杂度平均为O（n）
 * 缺点：需要修改原始数组
 * 思路2
 * 优点：不用修改原始数组，适合海量数据
 * 缺点：时间复杂度略高O(nlogk)
 */
