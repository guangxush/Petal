package javabase.thread;

/**
 * @author: guangxush
 * @create: 2021/04/05
 */
public class OneTask implements Runnable{
    /**
     * 第一个任务打印数字1
     */
    @Override
    public void run() {
        System.out.println("1");
    }
}
