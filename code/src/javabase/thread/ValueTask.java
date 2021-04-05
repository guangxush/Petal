package javabase.thread;

/**
 * @author: guangxush
 * @create: 2021/04/05
 */
public class ValueTask implements Runnable{

    public static int value = 0;

    @Override
    public void run() {
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        // 重新赋值
        value = 1000;
    }
}
