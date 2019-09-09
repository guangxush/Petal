package offer;

/**
 * @author: guangxush
 * @create: 2019/09/09
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int length = array.length;
        if (length == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        int bitResult = 0;
        for (int i = 0; i < length; i++) {
            bitResult ^= array[i];
        }
        int index = findFirstOne(bitResult);
        for (int i = 0; i < length; i++) {
            if (isBitOne(array[i], index)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    /**
     * 找到第一个1的index，即为异或结果不同的
     *
     * @param bitResult
     * @return
     */
    private int findFirstOne(int bitResult) {
        int index = 0;
        while ((bitResult & 1) == 0 && index < 32) {
            bitResult >>= 1;
            index++;
        }
        return index;
    }

    /**
     * 看当前的数字是否与该位相同
     *
     * @param target
     * @param index
     * @return
     */
    private boolean isBitOne(int target, int index) {
        return ((target >> index) & 1) == 1;
    }
}
