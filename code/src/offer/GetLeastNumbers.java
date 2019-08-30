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
        if (array==null || k<=0 || k>array.length) {
            return list;
        }
        int start = 0;
        int end = array.length - 1;
        int index = Partion(array, start, end);
        while (index != (k - 1)) {
            if (index > (k - 1)) {
                index = Partion(array, 0, index-1);
            } else {
                index = Partion(array, index+1, k-1-index);
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
                array[i] = array[j];
                array[j] = pivot;
                j--;
            }
        }
        return i;
    }


    public ArrayList<Integer> GetLeastNumbersTwo(int[] array, int k) {
        ArrayList<Integer> leastNumbers = new ArrayList<>();
        if(array==null || k<=0 || k>array.length) {
            return leastNumbers;
        }
        int[] numbers = new int[k];
        for(int i=0;i<k;i++){
            numbers[i] = array[i];
        }
        for(int i=k/2-1;i>=0;i--){
            adjustHeap(array, i ,k-1);
        }
        for(int i=k;i<array.length;i++){
            if(array[i]<numbers[0]){
                numbers[0] = array[i];
                adjustHeap(numbers, 0 ,k-1);
            }
        }
        for(int n :numbers){
            leastNumbers.add(n);
        }
        return leastNumbers;
    }

    private void adjustHeap(int[] array, int parentIndex, int end){
        int temp = array[parentIndex];
        int childIndex = 2*parentIndex+1;
        while(childIndex<end){
            if(childIndex+1<end&&array[childIndex+1]>array[childIndex]){
                childIndex++;
            }
            if(array[childIndex]<temp){
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2*parentIndex+1;
        }
        array[parentIndex] = temp;
    }

    public static void main(String[] args) {
        int[] array = {7, 9, 3, 6, 1, 11, 7, 4, 5, 8, 10};
        int k = 5;
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        ArrayList<Integer> result = new ArrayList<>();
        result = getLeastNumbers.GetLeastNumbersOne(array, k);
        System.out.println(result.toString());
//        result = getLeastNumbers.GetLeastNumbersTwo(array, k);
//        System.out.println(result.toString());
    }
}
