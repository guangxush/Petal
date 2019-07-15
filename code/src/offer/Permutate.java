package offer;

/**
 * @author: guangxush
 * @create: 2019/07/15
 * 字符串全排列
 */
public class Permutate {

    private static int count = 0;

    public static void swap(String[] str, int i, int j) {
        String temp = new String();
        temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void allPermutate(String[] str, int k, int length) {
        if(k==length-1){
            for(int i=0;i<length;i++){
                System.out.print(str[i]+" ");
            }
            System.out.println();
            count++;
        }else{
            for(int i=k;i<length;i++){
                swap(str, k ,i);
                allPermutate(str, k+1, length);
                swap(str, k ,i);
            }
        }
    }

    public static void main(String[] args) {
        String[] str={"A","B","C"};
        allPermutate(str, 0, str.length);
        System.out.println(count);
    }
}
