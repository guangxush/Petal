package leetcode.dp;

/**
 * @author: guangxush
 * @create: 2020/02/13
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * <p>
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 * Example 1:
 * <p>
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 * <p>
 * Input:
 * s = "aa"
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * Example 3:
 * <p>
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * Example 4:
 * <p>
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 * Example 5:
 * <p>
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 */
public class WildcardMatching44 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='*' && dp[0][i]){
                dp[0][i+1] = true;
            }
        }
        for(int i=0;i<s.length();i++){
            for(int j=0;j<p.length();j++){
                if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
                    dp[i+1][j+1] = dp[i][j];
                }
                if(p.charAt(j)=='*'){
                    dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    /**
     *  	''	*	a	*	b
     * ''	T	T	F	F	F
     * a	F	T	T	T	F
     * d	F	T	F	T	F
     * c	F	T	F	T	F
     * e	F	T	F	T	F
     * b	F	T	F	T	T
     * Dynamic Programming 是一大神器，因为字符串跟其子串之间的关系十分密切，正好适合 DP 这种靠推导状态转移方程的特性。
     * 那么先来定义dp数组，使用一个二维 dp 数组，其中 dp[i][j] 表示 s中前i个字符组成的子串和p中前j个字符组成的子串是否能匹配。
     * 大小初始化为 (m+1) x (n+1)，加1的原因是要包含 dp[0][0] 的情况，因为若s和p都为空的话，也应该返回 true，所以也要初始化 dp[0][0] 为 true。
     * 还需要提前处理的一种情况是，当s为空，p为连续的星号时的情况。由于星号是可以代表空串的，所以只要s为空，那么连续的星号的位置都应该为 true，所以先将连续星号的位置都赋为 true。
     * 然后就是推导一般的状态转移方程了，如何更新 dp[i][j]，首先处理比较 tricky 的情况，若p中第j个字符是星号，由于星号可以匹配空串，所以如果p中的前 j-1 个字符跟s中前i个字符匹配成功了（ dp[i][j-1] 为true）的话，则 dp[i][j] 也能为 true。
     * 或者若p中的前j个字符跟s中的前i-1个字符匹配成功了（ dp[i-1][j] 为true ）的话，则 dp[i][j] 也能为 true（因为星号可以匹配任意字符串，再多加一个任意字符也没问题）。
     * 若p中的第j个字符不是星号，对于一般情况，假设已经知道了s中前 i-1 个字符和p中前 j-1 个字符的匹配情况（即 dp[i-1][j-1] ），现在只需要匹配s中的第i个字符跟p中的第j个字符，若二者相等（ s[i-1] == p[j-1] ），或者p中的第j个字符是问号（ p[j-1] == '?' ），再与上 dp[i-1][j-1] 的值，就可以更新 dp[i][j] 了，参见代码如下：
     */
}
