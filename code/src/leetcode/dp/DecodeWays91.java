package leetcode.dp;

/**
 * @author: guangxush
 * @create: 2020/03/22
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * <p>
 * Example 1:
 * <p>
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 * <p>
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 *
 * 如果i-1和i构成的数字小于等于26，那么可能的个数是dp[i] = dp[i-1] + dp[i-2], 因为两个数字可以结合一起decode，也可以分开decode；
 * 如果大于26，只能分开decode，dp[i] = dp[i-1]，
 */
public class DecodeWays91 {
    public int numDecodings(String s) {
        //dp[n] = Math.max(composite <= 26 ? dp[n-2] + dp[n-1] : dp[n-1])
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int dp[] = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            int cur = (s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0';
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '0' || cur > 26) {
                    return 0;
                }
                dp[i + 1] = dp[i - 1];
            }else if (s.charAt(i - 1) == '0') {
                dp[i + 1] = dp[i];
            }else{
                dp[i + 1] = cur > 26 ? dp[i] : dp[i] + dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}
