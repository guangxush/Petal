package offer;

/**
 * @author: guangxush
 * @create: 2019/08/18
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Power {
    private double power(double base, int exponent) {
        if(exponent == 1){
            return base;
        }
        // 偶数
        if((exponent&1)==0){
            int temp = (int)power(base, exponent>>1);
            return temp*temp;
        }else{
            int temp = (int)power(base, (exponent-1)>>1);
            return temp*temp*base;
        }
    }
    public double Power(double base, int exp) {
        if (base == 0) {
            if (exp > 0){
                return 0;
            }
            else if (exp == 0){
                return 0;
            }
            else {
                throw new RuntimeException();
            }
        } else {
            if (exp > 0){
                return power(base, exp);
            }
            else if (exp == 0){
                return 1;
            }
            else{
                return 1 / power(base, -exp);
            }
        }
    }
}
/**
 * 思路：把指数偶数的一分为2，奇数的乘本身再一分为2
 */