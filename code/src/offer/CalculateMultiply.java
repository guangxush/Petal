package offer;

/**
 * @author: guangxush
 * @create: 2019/09/10
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */
public class CalculateMultiply {
    public int[] multiply(int[] A) {
        if(A==null||A.length==0){
            return A;
        }
        int[] B = new int[A.length];
        B[0] = 1;
        for(int i=1;i<A.length;i++){
            B[i] = B[i-1]*A[i];
        }
        int temp = 1;
        for(int j=A.length-2;j>=0;j--){
            temp = temp * B[j+1];
            B[j] = B[j] * temp;
        }
        return B;
    }
}
