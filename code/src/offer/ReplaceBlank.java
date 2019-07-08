package offer;

/**
 * @author: guangxush
 * @create: 2019/07/08
 * 题目:请实现一个函数，把字符串中的每个空格替换成“%20”。
 */
public class ReplaceBlank {
    public static void main(String[] args) {
        String s="We are happy.";
        System.out.println(replaceBlank(s));
        System.out.println(s.replaceAll(" " ,"%20"));
    }
    public static String replaceBlank(String input){
        if(input==null){
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)==' '){
                sb.append("%");
                sb.append("2");
                sb.append("0");
            }else{
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }

}
