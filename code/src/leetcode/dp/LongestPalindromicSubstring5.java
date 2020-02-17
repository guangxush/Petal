package leetcode.dp;

/**
 * @author: guangxush
 * @create: 2020/02/17
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring5 {
    /**
     * 用动态规划
     *
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int len = s.length();
        String ans = "";
        int max = 0;
        boolean[][] dp = new boolean[len][len];
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                boolean judge = s.charAt(i) == s.charAt(j);
                dp[i][j] = j - i > 2 ? dp[i + 1][j - 1] && judge : judge;
                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }

    /**
     * 不用动态规划
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            String max1 = extend(s, i, i);
            String max2 = extend(s, i, i + 1);
            if (max1.length() > max.length()) {
                max = max1;
            }
            if (max2.length() > max.length()) {
                max = max2;
            }
        }
        return max;
    }

    private String extend(String s, int i, int j) {
        for (; i >= 0 && j <= s.length(); i--, j++) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
        }
        return s.substring(i + 1, j);
    }
}
