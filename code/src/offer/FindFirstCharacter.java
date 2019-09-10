package offer;

import java.util.HashMap;

/**
 * @author: guangxush
 * @create: 2019/09/10
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class FindFirstCharacter {
    HashMap<Character,Integer> map=new HashMap<>();
    String s = new String("");

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        s+=ch;
        if(!map.containsKey(ch)){
            map.put(ch, 1);
        }else{
            map.put(ch, map.get(ch)+1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char[] cs = s.toCharArray();
        for(char c:cs){
            if(map.get(c)==1){
                return c;
            }
        }
        return '#';
    }
}
