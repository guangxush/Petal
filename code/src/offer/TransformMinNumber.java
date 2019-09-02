package offer;

import java.util.Arrays;

/**
 * @author: guangxush
 * @create: 2019/09/02
 * 给定一个数组，移动里面的数字找出比当前数字大的最小的数字
 */
public class TransformMinNumber {
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 2, 5};
        int temp = 0;
        for(int i=array.length-1;i>0;i--){
            if(array[i-1]<array[i]){
                temp = i;
                break;
            }
        }
        if(temp == 0){
            System.out.println(Arrays.toString(array));
            return;
        }
        int min = array[temp];
        int minIndex = temp;
        for(int i=temp+1 ;i<array.length;i++){
            if(array[i]<min){
                min = array[i];
                minIndex = i;
            }
        }
        int pre = array[temp-1];
        array[temp-1] = min;
        array[minIndex] = pre;
        System.out.println(Arrays.toString(array));
    }
}
