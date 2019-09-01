package offer;

/**
 * @author: guangxush
 * @create: 2019/09/01
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class NumberOf1Between1AndN {
    public static int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while (temp != 0) {
                if (temp % 10 == 1) {
                    count++;
                }
                temp = temp / 10;
            }
        }
        return count;
    }

    public static int NumberOf1Between1AndN_Solution1(int n) {
        int count = 0;
        while(n>0){
            String str = String.valueOf(n);
            char[] chars = str.toCharArray();
            for(int i=0;i<chars.length;i++){
                if(chars[i]=='1'){
                    count++;
                }
            }
        }
        return count;
    }

    public static int NumberOf1Between1AndN_Solution2(int n){
        int count = 0;
        StringBuffer sb = new StringBuffer();
        for(int i=100;i<=n;i++){
            sb.append(i);
        }
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN.NumberOf1Between1AndN_Solution(1));
    }
}
