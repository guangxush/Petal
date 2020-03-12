package leetcode.dp;

/**
 * @author: guangxush
 * @create: 2020/03/12
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * <p>
 * Below is one possible representation of s1 = "great":
 * <p>
 * great
 * /    \
 * gr    eat
 * / \    /  \
 * g   r  e   at
 * / \
 * a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * <p>
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 * <p>
 * rgeat
 * /    \
 * rg    eat
 * / \    /  \
 * r   g  e   at
 * / \
 * a   t
 * We say that "rgeat" is a scrambled string of "great".
 * <p>
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 * <p>
 * rgtae
 * /    \
 * rg    tae
 * / \    /  \
 * r   g  ta  e
 * / \
 * t   a
 * We say that "rgtae" is a scrambled string of "great".
 * <p>
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "great", s2 = "rgeat"
 * Output: true
 * Example 2:
 * <p>
 * Input: s1 = "abcde", s2 = "caebd"
 * Output: false
 */
public class ScrambleString87 {
    /**
     * 如果字符串长度为1，那么必须两个字符串完全相同；
     * 如果字符串长度为2，例如s1='ab'，则s2='ab'或s2='ba'才行
     * 如果字符串任意长度，那么可以把s1分为a1, b1两部分，s2分为a2,b2两部分。需要满足：((a1=a2)&&(b1=b2)) || ((a1=b2)&&(a2=b1)) =>可用递归
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble1(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if(n != m){
            return false;
        }
        if(n == 0) {
            return true;
        }
        if(s1.equals(s2)) {
            return true;
        }
        int[] freq = new int[26];
        for(int i = 0; i < n; i++){
            freq[s1.charAt(i) - 97]++;
            freq[s2.charAt(i) - 97]--;
        }
        // if freq[i] != 0  => different characters, hence node equality condition is violated.
        for(int i = 0; i < n; i++) {
            if(freq[s1.charAt(i) - 97] != 0){
                return false;
            }
        }
        // The following loop has conditions similar to what we use for mirror trees.
        for(int i = 1; i < n; i++){
            if(isScramble1(s1.substring(0,i),s2.substring(0,i))
                    && isScramble1(s1.substring(i),s2.substring(i))) {
                return true;
            }
            if(isScramble1(s1.substring(0,i),s2.substring(n - i))
                    && isScramble1(s1.substring(i),s2.substring(0,n - i))) {
                return true;
            }
        }
        return false;
    }
}
