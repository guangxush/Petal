package leetcode.dp;

import java.util.Arrays;

/**
 * @author: guangxush
 * @create: 2020/03/08
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * Output: 6
 *
 * height:
 * 1 0 1 0 0
 * 2 0 2 1 1
 * 3 1 3 2 2
 * 4 0 0 3 0
 *
 * left:
 * 0 0 2 0 0
 * 0 0 2 2 2
 * 0 0 2 2 2
 * 0 0 0 3 0
 *
 * right:
 * 1 5 3 5 5
 * 1 5 3 5 5
 * 1 5 3 5 5
 * 1 5 5 4 5
 */
public class MaximalRectangle85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int maxA = 0;
        int[] right = new int[n];
        int[] left = new int[n];
        int[] heights = new int[n];
        Arrays.fill(right, n);
        for (int i = 0; i < m; i++) {
            int curleft = 0, curright = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    // each i has own left[], each will renew
                    left[j] = Math.max(curleft, left[j]);
                } else {
                    // most next position to zero
                    left[j] = 0;
                    curleft = j + 1;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(curright, right[j]);
                } else {
                    // remain at last zero position
                    right[j] = n;
                    curright = j;
                }
            }
            for (int j = 0; j < n; j++) {
                maxA = Math.max(maxA, (right[j] - left[j]) * heights[j]);
            }
        }
        return maxA;
    }
}
