package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author: guangxush
 * @create: 2019/08/26
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() < 1) {
            return res;
        }
        TreeSet<String> set = new TreeSet<>();
        char[] chs = str.toCharArray();
        change(chs, 0, set);
        res.addAll(set);
        return res;
    }

    public void change(char[] chs, int start, TreeSet<String> set) {
        if (start == chs.length - 1) {
            set.add(String.valueOf(chs));
        }
        for (int i = start; i < chs.length; i++) {
            swap(chs, start, i);
            change(chs, start + 1, set);
            swap(chs, start, i);
        }
    }

    public void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}
