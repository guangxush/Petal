package javabase.thread;

/**
 * @author: guangxush
 * @create: 2021/04/05
 */
public class PrintTask implements Runnable{
    @Override
    public void run() {
        // 打印value值
        while(ValueTask.value==0){
            // 为0时,使当前线程放弃执行权
            Thread.yield();
        }
        System.out.println(ValueTask.value);
    }
}
