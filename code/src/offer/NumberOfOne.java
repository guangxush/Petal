package offer;

/**
 * @author: guangxush
 * @create: 2019/08/18
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOfOne {
    private int NumberOfOne(int n){
        int count = 0;
        int flag = 1;
        while(flag != 0){
            if((n&flag)!=0){
                count ++;
            }
            flag = flag<<1;
        }
        return count;
    }
    public int NumberOf1(int n) {
        int count = 0;
        while(n!=0){
            count++;
            n = (n-1)&n;
        }
        return count;
    }
}
/**
 * 从n的2进制形式的最右边开始判断是不是1,该解法如果输入时负数会陷入死循环，因为负数右移时，在最高位补得是1
 * 用1（1自身左移运算，其实后来就不是1了）和n的每位进行位与，来判断1的个数
 */
