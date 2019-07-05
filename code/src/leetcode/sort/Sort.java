package leetcode.sort;

import java.util.Arrays;

/**
 * @author: guangxush
 * @create: 2019/07/04
 */
public class Sort {
    public static void main(String[] args) {
        System.out.println("sort:");
        int[] a = new int[]{1, 8, 2, 9, 6, 7, 5, 0, 4, 3};
        // quickSort(a, 0, a.length - 1);
        // mergeSort(a, 0, a.length - 1);
        // heapSort(a);
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int[] a, int start, int end) {
        if (start < end) {
            int pivot = a[start];
            int i = start;
            int j = end;
            while (i < j) {
                while (i < j && pivot < a[j]) {
                    j--;
                }
                if (i < j) {
                    a[i] = a[j];
                    a[j] = pivot;
                    i++;
                }
                while (i < j && pivot > a[i]) {
                    i++;
                }
                if (i < j) {
                    a[j] = a[i];
                    a[i] = pivot;
                    j--;
                }
            }
            quickSort(a, start, i - 1);
            quickSort(a, i + 1, end);
        }
    }

    private static void mergeSort(int[] a, int begin, int end) {
        if (begin < end) {
            int mid = (begin + end) / 2;
            mergeSort(a, begin, mid);
            mergeSort(a, mid + 1, end);
            merge(a, begin, mid, end);
        }
    }

    private static void merge(int[] a, int begin, int mid, int end) {
        int[] temp = new int[a.length];
        int i = begin;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= end) {
            if (a[i] < a[j]) {
                temp[t++] = a[i++];
            } else {
                temp[t++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = a[i++];
        }
        while (j <= end) {
            temp[t++] = a[j++];
        }
        t = 0;
        while (begin <= end) {
            a[begin++] = temp[t++];
        }
    }

    private static void adjustHeap(int[] a, int parentIndex, int length) {
        int temp = a[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            if (childIndex + 1 < length && a[childIndex + 1] > a[childIndex]) {
                childIndex++;
            }
            if (temp >= a[childIndex]) {
                break;
            }
            a[parentIndex] = a[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * parentIndex + 1;
        }
        a[parentIndex] = temp;
    }

    private static void heapSort(int[] a) {
        for (int i = (a.length - 2) / 2; i >= 0; i--) {
            adjustHeap(a, i, a.length);
        }
        System.out.println(Arrays.toString(a));
        for (int i = a.length - 1; i >= 0; i--) {
            int temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            adjustHeap(a, 0, i);
        }
    }

    public static void bubbleSort(int[] a) {
        int n = a.length;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n - 1 - j; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }
    }

    public static void insertSort(int[] a) {
        int n = a.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            int j = i - 1;
            temp = a[i];
            for (; j >= 0 && a[j] > temp; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = temp;
        }
    }

    public static void selectSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int temp = i;
            int value = a[i];
            for (int j = i + 1; j < n; j++) {
                if (a[j] < value) {
                    temp = j;
                    value = a[j];
                }
            }
            a[temp] = a[i];
            a[i] = value;
        }
    }

}
