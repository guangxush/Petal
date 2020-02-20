package leetcode.dp;

import java.util.regex.Matcher;

/**
 * @author: guangxush
 * @create: 2020/02/19
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * Example 1:
 * <p>
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 * <p>
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
public class LongestValidParentheses32 {
    public int longestValidParentheses(String s) {
        int result = 0;
        int leftCount = 0;
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount ++;
            }else if(leftCount>0){
                dp[i] = dp[i-1]+2;
                dp[i] += i-dp[i]>=0?dp[i-dp[i]]:0;
                result = Math.max(result, dp[i]);
                leftCount--;
            }
        }
        return result;
    }
}
