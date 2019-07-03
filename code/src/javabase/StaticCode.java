package javabase;

/**
 * @author: guangxush
 * @create: 2019/07/03
 */
public class StaticCode {

    static String prior = "done";
    static String last = f() ? g() : prior;

    public static boolean f() {
        return true;
    }

    public static String g() {
        return "hello";
    }

    static {
        System.out.println(last);
        g();
    }
}
