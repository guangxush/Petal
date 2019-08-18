package offer;

/**
 * @author: guangxush
 * @create: 2019/08/18
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class Fibonacci {
    public int Fibonacci(int n) {
        int result = 0;
        int preOne = 0;
        int preTwo = 1;
        if(n==0){
            return preOne;
        }else if(n==1){
            return preTwo;
        }
        for(int i=2;i<=n;i++){
            result = preOne + preTwo;
            preOne = preTwo;
            preTwo = result;
        }
        return result;
    }
}
