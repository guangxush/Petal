package leetcode.list;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author: guangxush
 * @create: 2019/07/02
 * 854. K-Similar Strings
 * Strings A and B are K-similar (for some non-negative integer K) if we can swap the positions of two letters in A exactly K times so that the resulting string equals B.
 *
 * Given two anagrams A and B, return the smallest K for which A and B are K-similar.
 *
 * Example 1:
 *
 * Input: A = "ab", B = "ba"
 * Output: 1
 * Example 2:
 *
 * Input: A = "abc", B = "bca"
 * Output: 2
 * Example 3:
 *
 * Input: A = "abac", B = "baca"
 * Output: 2
 * Example 4:
 *
 * Input: A = "aabc", B = "abca"
 * Output: 2
 * Note:
 *
 * 1 <= A.length == B.length <= 20
 * A and B contain only lowercase letters from the set {'a', 'b', 'c', 'd', 'e', 'f'}
 */
public class KSimilarStrings {
    public int kSimilarity(String A, String B) {
        if((A.equals(B))) {
            return 0;
        }
        int res = 0;
        Set<String> used = new HashSet<>();
        Deque<String> queue = new LinkedList<>();
        queue.add(A);
        int start = 0;
        while (A.charAt(start) == B.charAt(start)){
            start++;
        }
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String s = queue.removeLast();
                int j = start;
                while (s.charAt(j) == B.charAt(j)){
                    j++;
                }
                for (int k = j+1; k < B.length(); k++) {
                    if (s.charAt(k) == B.charAt(j)) {
                        String ss = swap(s, j, k);
                        if (used.contains(ss)){
                            continue;
                        }
                        if (ss.equals(B)){
                            return res+1;
                        }
                        queue.addFirst(ss);
                        used.add(ss);
                    }
                }
            }
            res++;
            start++;
        }

        return res;
    }
    public String swap(String s, int i, int j){
        char[] cs=s.toCharArray();
        char tmp=cs[i];
        cs[i]=cs[j];
        cs[j]=tmp;
        return new String(cs);
    }
}
