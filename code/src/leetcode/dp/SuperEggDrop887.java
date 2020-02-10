package leetcode.dp;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * @author: guangxush
 * @create: 2020/02/09
 * You are given K eggs, and you have access to a building with N floors from 1 to N.
 *
 * Each egg is identical in function, and if an egg breaks, you cannot drop it again.
 *
 * You know that there exists a floor F with 0 <= F <= N such that any egg dropped at a floor higher than F will break, and any egg dropped at or below floor F will not break.
 *
 * Each move, you may take an egg (if you have an unbroken one) and drop it from any floor X (with 1 <= X <= N).
 *
 * Your goal is to know with certainty what the value of F is.
 *
 * What is the minimum number of moves that you need to know with certainty what F is, regardless of the initial value of F?
 *
 *
 *
 * Example 1:
 *
 * Input: K = 1, N = 2
 * Output: 2
 * Explanation:
 * Drop the egg from floor 1.  If it breaks, we know with certainty that F = 0.
 * Otherwise, drop the egg from floor 2.  If it breaks, we know with certainty that F = 1.
 * If it didn't break, then we know with certainty F = 2.
 * Hence, we needed 2 moves in the worst case to know what F is with certainty.
 * Example 2:
 *
 * Input: K = 2, N = 6
 * Output: 3
 * Example 3:
 *
 * Input: K = 3, N = 14
 * Output: 4
 *
 *
 * Note:
 *
 * 1 <= K <= 100
 * 1 <= N <= 10000
 */
public class SuperEggDrop887 {
    /**
     * O(K * N^2)
     * 需要求一个最优决策使得步数最小，但是实际的步数是随着真实结果变化而变化的。
     * 于是，为了保证在我们假设的步数内一定能够解完，我们可以假设每次决策都会得到最坏结果。
     *
     * dp[n][k] 表示用k个鸡蛋测n层最少需要多少步。
     * 我们可以枚举第一次在第i层扔鸡蛋，会得到两种结果:
     *
     * 鸡蛋坏掉: 我们接下来需要面对的情形是: 用 k-1 个鸡蛋来测量 i-1 层，所以最少需要 dp[i-1][k-1] 步。
     * 鸡蛋没坏: 我们接下来要面对的情形是: 用 k 个鸡蛋来测量 n-i 层，所以最少需要 dp[n-i][k] 步。
     * 因为我们总会面对最坏情况，所以，在第i层扔，会用 max(dp[i-1][k-1], dp[n-i][k]) + 1 步。
     * 所以我们的递推式如下:
     * dp[n][k] = min{ max(dp[i-1][k-1], dp[n-i][k]) + 1 } (1 <= i <= n)
     * @param K
     * @param N
     * @return
     */
    public int superEggDrop1(int K, int N) {
        int dp[][] = new int[N+2][K+2];
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
            dp[i][1] = i;
        }
        for (int j = 2; j <= K; j++) {
            for (int i = 1; i <= N; i++) {
                dp[i][j] = i;
                for (int k = 1; k < i; k++) {
                    dp[i][j] = min(dp[i][j], max(dp[k-1][j-1], dp[i-k][j]) + 1);
                }
            }
        }
        return dp[N][K];
    }

    /**
     * 我们可以改变一下求解的思路，求k个鸡蛋在i步内可以测出多少层：
     * 假设: dp[i][k] 表示在i步内用k个鸡蛋最多能测出的层数。
     * 那么，问题可以转化为当 k <= K 时，找一个最小的i，使得dp[i][k] <= N。
     *
     * 我们来考虑下求解dp[i][k]的策略：
     * 假设我们有k个鸡蛋第i步时，在第X层扔鸡蛋。这时候，会有两种结果，鸡蛋碎了，或者没碎。
     * 如果鸡蛋没碎，我们接下来会在更高的楼层扔，最多能确定 X + dp[i-1][k] 层的结果；
     * 如果鸡蛋碎了，我们接下来会在更低的楼层扔，最多能确定 Y + dp[i-1][k-1] 层的结果 (假设在第X层上还有Y层)。
     * 因此，这次扔鸡蛋，我们最多能测出 dp[i-1][k-1] (摔碎时能确定的层数) + dp[i-1][k] (没摔碎时能确定的层数) + 1 (本层) 层的结果。
     * 另外，我们知道一个鸡蛋一次只能测一层，没有鸡蛋一层都不能测出来dp[i][0] = 0。
     * 因此我们可以列出完整的递推式:
     * dp[0][k] = 0
     * dp[i][1] = i (i > 0)
     * dp[i][k] = dp[i-1][k-1] + dp[i-1][k] + 1 (k > 0, i>0)
     * @param K
     * @param N
     * @return
     */
    public int superEggDrop2(int K, int N) {
        int dp[][] =  new int[N+2][K+2];
        dp[0][0] = 0;
        for (int i = 1; i <= N; i++) {
            dp[i][0] = 0;
            for (int k = 1; k <= K; k++) {
                dp[i][k] = dp[i-1][k] + dp[i-1][k-1] + 1;
                if (dp[i][k] >= N) {
                    return i;
                }
            }
        }
        return N;
    }
}
