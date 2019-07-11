package offer;

/**
 * @author: guangxush
 * @create: 2019/07/11
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该函数数组中数字的顺序，使得 所有奇数位于数组的前半部分，所有的数组位于数组的后半部分
 */
public class OddBeforeEven {
    public void order(int[] array){
        if(array==null||array.length==0){
            return;
        }
        int start = 0;
        int end = array.length - 1;
        while(start<end){
            while(start<end&&!isEven(array[start])){
                start ++;
            }
            while(start<end&&isEven(array[end])){
                end--;
            }
            if(start<end){
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
    }

    private boolean isEven(int n){
        return n%2 == 0;
    }
}
