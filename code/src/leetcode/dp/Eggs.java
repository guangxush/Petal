package leetcode.dp;

/**
 * @author: guangxush
 * @create: 2019/10/16
 */
public class Eggs {
    public int getMinSteps(int eggNum, int floorNum) {
        if (eggNum < 1 || floorNum < 1) {
            return 0;
        }
        //备忘录，存储eggNum个鸡蛋，floorNum层楼条件下的最优化尝试次数
        int[][] cache = new int[eggNum + 1][floorNum + 1];
        //把备忘录每个元素初始化成最大的尝试次数
        for (int i = 1; i <= eggNum; i++) {
            for (int j = 1; j <= floorNum; j++) {
                cache[i][j] = j;
            }
        }
        for (int n = 2; n <= eggNum; n++) {
            for (int m = 1; m <= floorNum; m++) {
                for (int k = 1; k < m; k++) {
                    //扔鸡蛋的楼层从1到m枚举一遍，如果当前算出的尝试次数小于上一次算出的尝试次数，则取代上一次的尝试次数。
                    //这里可以打印k的值，从而知道第一个鸡蛋是从第几次扔的。
                    cache[n][m] = Math.min(cache[n][m], 1 + Math.max(cache[n - 1][k - 1], cache[n][m - k]));
                }
            }
        }
        return cache[eggNum][floorNum];
    }

    public static void main(String[] args) {
        Eggs e = new Eggs();
        System.out.println(e.getMinSteps(5, 500));
    }
}
